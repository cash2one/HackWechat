package com.tencent.mm.e.b;

import android.media.AudioRecord;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    AudioRecord fkJ;
    int fkV;
    private int fkY = 12800;
    private b fkZ = new b(this);
    boolean fkv;
    a fla = null;
    c.a flb;
    private final Object flc = new Object();
    final byte[] fld = new byte[0];
    final Object fle = new Object();
    private Timer flf = null;
    private boolean flg = false;
    private boolean flh = false;
    boolean mIsMute = false;
    int mStatus = 0;

    public e(AudioRecord audioRecord, boolean z, int i, c.a aVar, boolean z2) {
        this.fkJ = audioRecord;
        this.fkv = z;
        this.fkV = i;
        this.flb = aVar;
        this.flh = z2;
    }

    public final boolean vr() {
        boolean z = true;
        x.i("MicroMsg.RecordModeAsyncRead", JsApiStartRecordVoice.NAME);
        synchronized (this.fle) {
            this.mStatus = 1;
        }
        com.tencent.mm.sdk.f.e.b(this.fkZ, "RecordModeAsyncRead_record", 10);
        if (true == this.flh) {
            boolean z2;
            this.fla = new a();
            if (this.fla == null) {
                x.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.fkY = this.fkV * 20;
                x.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.fkY);
                a aVar = this.fla;
                int i = this.fkY;
                if (i <= 0) {
                    z2 = true;
                } else {
                    aVar.gBR = new byte[i];
                    if (aVar.gBR == null) {
                        z2 = true;
                    } else {
                        aVar.gBP = i;
                        if (aVar.gBU) {
                            aVar.gBV = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    x.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("audioBuffer init failed, error code = -1").toString());
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.flg || this.flf != null) {
                    x.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.flg);
                } else {
                    this.flf = new Timer();
                    if (this.flf != null) {
                        z = false;
                    }
                }
                if (z) {
                    x.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return false;
                }
                this.flf.scheduleAtFixedRate(new a(this), 60, 20);
                this.flg = true;
            } else {
                x.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        return true;
    }

    public final void uE() {
        x.i("MicroMsg.RecordModeAsyncRead", JsApiStopRecordVoice.NAME);
        synchronized (this.fle) {
            this.mStatus = 3;
        }
        synchronized (this.fld) {
            this.fld.notify();
        }
        com.tencent.mm.sdk.f.e.Q(this.fkZ);
        try {
            com.tencent.mm.sdk.f.e.S(this.fkZ);
        } catch (InterruptedException e) {
        }
        if (this.fla != null) {
            if (this.flf != null) {
                this.flf.cancel();
                this.flf = null;
            }
            a aVar = this.fla;
            aVar.gBP = 0;
            aVar.gBQ = 0;
            aVar.gBS = 0;
            aVar.gBT = 0;
            aVar.gBR = null;
            synchronized (this.flc) {
                this.fla = null;
                this.flb = null;
            }
            this.flg = false;
            this.fla = null;
        }
    }

    public final int vu() {
        synchronized (this.flc) {
            if (this.fla != null) {
                int i = this.fla.gBP;
                return i;
            }
            return -1;
        }
    }

    public final int vv() {
        synchronized (this.flc) {
            if (this.fla != null) {
                int xE = this.fla.xE();
                return xE;
            }
            return -1;
        }
    }

    public final int t(byte[] bArr, int i) {
        int i2 = -1;
        synchronized (this.flc) {
            if (this.fla != null) {
                a aVar = this.fla;
                if (i > 0 && i <= aVar.xE() && bArr != null && aVar.gBS != aVar.gBT) {
                    if (aVar.gBU) {
                        aVar.gBV.lock();
                    }
                    if (aVar.gBS < aVar.gBT) {
                        System.arraycopy(aVar.gBR, aVar.gBS, bArr, 0, i);
                        aVar.gBS += i;
                    } else if (i <= aVar.gBP - aVar.gBS) {
                        System.arraycopy(aVar.gBR, aVar.gBS, bArr, 0, i);
                        aVar.gBS += i;
                    } else {
                        System.arraycopy(aVar.gBR, aVar.gBS, bArr, 0, aVar.gBP - aVar.gBS);
                        System.arraycopy(aVar.gBR, 0, bArr, aVar.gBP - aVar.gBS, i - (aVar.gBP - aVar.gBS));
                        aVar.gBS = i - (aVar.gBP - aVar.gBS);
                    }
                    if (aVar.gBU) {
                        aVar.gBV.unlock();
                    }
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public final void aQ(boolean z) {
        this.mIsMute = z;
    }
}
