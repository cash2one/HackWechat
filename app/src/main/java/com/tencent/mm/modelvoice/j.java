package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import org.xwalk.core.XWalkUpdater;

public final class j implements d {
    AudioTrack afZ;
    private int fCR;
    String fileName;
    b fme;
    String hWQ;
    String hWR;
    OnCompletionListener hXa;
    OnErrorListener hXb;
    a hXe;
    d.b hXf;
    private int hXg;
    private int hXh;
    private int hXi;
    private Runnable hXj;
    com.tencent.qqpinyin.voicerecoapi.a hXk;
    private int hXl;
    int hXm;
    boolean hXn;
    byte[] hXo;
    int hXp;
    FileInputStream hXq;
    int hXr;
    int status;

    static /* synthetic */ void a(j jVar) {
        if (jVar.hXj != null) {
            e.S(jVar.hXj);
            jVar.hXj = null;
        }
    }

    public final int getStatus() {
        return this.status;
    }

    public j() {
        int i = 0;
        this.fileName = "";
        this.hXe = null;
        this.hXf = null;
        this.status = 0;
        this.hXg = 2;
        this.hXh = 16000;
        this.fCR = 1;
        this.hXi = 20;
        this.hXk = null;
        this.hXm = 0;
        this.hXn = false;
        this.hWQ = "";
        this.hWR = "";
        this.hXo = new byte[com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE];
        this.hXp = 0;
        this.hXq = null;
        this.hXr = d.CTRL_INDEX;
        this.hXa = new 1(this);
        this.hXb = new 2(this);
        this.hXk = new com.tencent.qqpinyin.voicerecoapi.a();
        com.tencent.qqpinyin.voicerecoapi.a aVar = this.hXk;
        if (aVar.zQO != 0) {
            i = -103;
        } else {
            int nativeTRSpeexDecodeInit = aVar.zQP.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == XWalkUpdater.ERROR_SET_VERNUM || nativeTRSpeexDecodeInit == -102) {
                i = nativeTRSpeexDecodeInit;
            } else {
                aVar.zQO = nativeTRSpeexDecodeInit;
                aVar.zQM = new byte[(com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE * 15)];
            }
        }
        if (i != 0) {
            x.e("speex", "res: " + i);
        }
    }

    public j(Context context) {
        this();
        this.fme = new b(context);
    }

    public final void a(a aVar) {
        this.hXe = aVar;
    }

    public final void a(d.b bVar) {
        this.hXf = bVar;
    }

    final void UB() {
        if (this.afZ != null) {
            this.afZ.stop();
            this.afZ.release();
            this.afZ = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aM(boolean z) {
        int i;
        int i2 = 3;
        this.hXn = true;
        if (this.fCR == 2) {
            this.hXg = 3;
        } else {
            this.hXg = 2;
        }
        this.hXl = AudioTrack.getMinBufferSize(this.hXh, this.hXg, 2);
        if (this.afZ != null) {
            try {
                this.afZ.stop();
                this.afZ.release();
            } catch (Exception e) {
                x.e("MicroMsg.SpeexPlayer", e.getMessage());
            } finally {
                this.afZ = null;
            }
        }
        if (z) {
            i = 3;
        } else {
            boolean z2 = false;
        }
        if (q.gFV.gCG) {
            q.gFV.dump();
        }
        i2 = i;
        this.afZ = new com.tencent.mm.compatible.b.d(i2, this.hXh, this.hXg, 2, this.hXl * 8);
        try {
            this.afZ.play();
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[]{e2.getMessage()});
        }
        this.hXn = false;
    }

    public final boolean K(String str, boolean z) {
        return L(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return L(str, z);
    }

    private boolean L(String str, boolean z) {
        if (this.status != 0) {
            x.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            return false;
        }
        x.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fileName = str;
        try {
            cc(z);
        } catch (Throwable e) {
            try {
                cc(true);
            } catch (Exception e2) {
                x.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
                this.status = -1;
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cc(boolean z) {
        int i = 3;
        if (com.tencent.mm.a.e.bO(this.fileName)) {
            int i2 = z ? 3 : 0;
            try {
                if (q.gFV.gCG) {
                    q.gFV.dump();
                }
                i = i2;
                this.hXl = AudioTrack.getMinBufferSize(this.hXh, this.hXg, 2);
                UB();
                this.afZ = new com.tencent.mm.compatible.b.d(i, this.hXh, this.hXg, 2, this.hXl * 8);
                this.hXr = (((this.hXh / 1000) * this.fCR) * this.hXi) * 2;
                if (this.fme != null) {
                    this.fme.requestFocus();
                }
                if (this.afZ != null) {
                    try {
                        this.afZ.play();
                        this.hXj = new 3(this);
                        e.post(this.hXj, "SpeexPlayer_play");
                    } catch (Exception e) {
                        x.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[]{e.getMessage()});
                    }
                }
            } catch (Throwable e2) {
                if (this.fme != null) {
                    this.fme.zd();
                }
                UB();
                x.e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + e2.getMessage());
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e2)});
            }
        }
    }

    public final boolean aK(boolean z) {
        if (this.status != 1) {
            return false;
        }
        this.status = 2;
        synchronized (this.hWR) {
            try {
                x.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.hWR.wait();
                x.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.fme != null && z) {
                    this.fme.zd();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
                if (this.fme != null && z) {
                    this.fme.zd();
                }
                return false;
            } catch (Throwable th) {
                if (this.fme != null && z) {
                    this.fme.zd();
                }
            }
        }
        return true;
    }

    public final boolean vc() {
        if (this.status != 2) {
            return false;
        }
        this.status = 1;
        synchronized (this.hWQ) {
            try {
                x.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.hWQ.notify();
                x.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.fme != null) {
                    this.fme.requestFocus();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
                if (this.fme != null) {
                    this.fme.requestFocus();
                }
                return false;
            } catch (Throwable th) {
                if (this.fme != null) {
                    this.fme.requestFocus();
                }
            }
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean vo() {
        x.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.hWQ) {
                try {
                    this.hWQ.notify();
                    if (this.fme != null) {
                        this.fme.zd();
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
                    UB();
                    if (this.fme != null) {
                        this.fme.zd();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.fme != null) {
                        this.fme.zd();
                    }
                }
            }
            return true;
        }
        x.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        return false;
    }

    public final double vf() {
        return 0.0d;
    }

    public final void b(b.a aVar) {
        if (aVar != null && this.fme != null) {
            this.fme.a(aVar);
        }
    }
}
