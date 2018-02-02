package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.plugin.talkroom.component.e.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a implements Runnable {
    private static final int saG = com.tencent.mm.plugin.talkroom.model.a.saG;
    private AudioTrack afZ;
    private int bufferSize = (((saG / 1000) * 20) * 2);
    private boolean fhL = false;
    private boolean fvI = true;
    private boolean hXn = false;
    private boolean hYW = true;
    private af handler = new af(Looper.getMainLooper());
    private final Object lock = new Object();
    private int nRH = 0;
    private int saH = saG;
    private final c saI;
    private boolean saJ = false;
    private long saK = 0;
    private int saL;
    private long saM = 0;
    private v2engine sar;
    private short sas;
    private short sat;

    public h(v2engine com_tencent_mm_plugin_talkroom_component_v2engine, c cVar) {
        this.sar = com_tencent_mm_plugin_talkroom_component_v2engine;
        this.saI = cVar;
        this.hXn = true;
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.stop();
        }
        if (this.afZ != null) {
            try {
                this.afZ.release();
            } catch (Exception e) {
            }
        }
        v2engine.Hh().h(true, false);
        int ba = v2engine.Hh().ba(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.saH, 2, 2);
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.afZ = new d(ba, this.saH, 2, 2, minBufferSize * 8);
            this.hXn = false;
        }
    }

    public final void bxv() {
        this.fvI = true;
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.pause();
        }
    }

    public final void bEA() {
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.play();
        }
        synchronized (this.lock) {
            this.fvI = false;
            this.lock.notify();
        }
        this.sat = (short) 0;
        this.sas = (short) 0;
    }

    public final void release() {
        x.i("MicroMsg.TalkRoomPlayer", "release");
        this.fhL = true;
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.stop();
        }
        if (this.afZ != null) {
            this.afZ.release();
        }
        synchronized (this.lock) {
            this.fvI = false;
            this.lock.notify();
        }
    }

    public final void run() {
        while (!this.fhL) {
            if (this.hXn) {
                try {
                    Thread.sleep(50);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    if (this.fvI) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                        }
                    }
                }
                long j = this.saM;
                this.saM = bh.Wq();
                j = this.saM - j;
                if (j < 20 && j > 0) {
                    try {
                        synchronized (this.lock) {
                            this.lock.wait(j);
                        }
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e22, "", new Object[0]);
                    }
                }
                try {
                    int GetAudioData;
                    PByteArray pByteArray = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.sar.IsSilenceFrame();
                    if (IsSilenceFrame == 0) {
                        GetAudioData = this.sar.GetAudioData(pByteArray, this.bufferSize, pInt, pInt2);
                    } else {
                        GetAudioData = 0;
                    }
                    if (GetAudioData < 0) {
                        this.nRH++;
                        x.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", new Object[]{Integer.valueOf(GetAudioData), Integer.valueOf(this.nRH)});
                        if (this.nRH >= 100) {
                            this.nRH = 0;
                            this.fvI = true;
                        }
                    } else {
                        boolean z;
                        if (IsSilenceFrame == 0) {
                            if (this.afZ.getPlayState() != 3) {
                                this.afZ.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (GetAudioData = 0; GetAudioData < length / 2; GetAudioData++) {
                                short s = (short) ((bArr[GetAudioData * 2] & 255) | (bArr[(GetAudioData * 2) + 1] << 8));
                                if (s > this.sas) {
                                    this.sas = s;
                                }
                            }
                            this.afZ.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.hYW) {
                            this.afZ.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.saK = bh.Wq();
                            z = false;
                        } else if (bh.bA(this.saK) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((!((!this.hYW && this.saL == pInt2.value) || z || pInt.value == 0) || (!this.hYW && z)) && !this.saJ) {
                            if (!(z || pInt2.value == 0)) {
                                this.saL = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueueV2(new 1(this, pInt, pInt2, z));
                            this.hYW = z;
                        }
                    }
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e222, "", new Object[0]);
                    x.e("MicroMsg.TalkRoomPlayer", e222.toString());
                }
            }
        }
    }

    public final int bEz() {
        if (this.sat < this.sas) {
            this.sat = this.sas;
        }
        if (this.sat == (short) 0) {
            return 0;
        }
        short s = (short) ((this.sas * 100) / this.sat);
        this.sas = (short) 0;
        return s;
    }

    public final void start() {
        e.b(this, "TalkRoomPlayer_start").start();
    }
}
