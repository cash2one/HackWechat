package com.tencent.mm.e.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import com.tencent.mm.be.c.1;
import com.tencent.mm.be.d;
import com.tencent.mm.be.d$a;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static Object fjX = new Object();
    private int fjM = 0;
    private String fjN = null;
    private int fjO;
    private final Object fjP = new Object();
    private c fjQ = null;
    private b fjR;
    private com.tencent.mm.be.c fjS = null;
    private d$a fjT = null;
    private long fjU = 0;
    private long fjV = 0;
    private int fjW = 0;
    private int fjY = 16000;
    private boolean fjZ = false;
    public MediaRecorder fka;
    public c fkb = null;
    public a fkc;
    public c fkd;
    private volatile boolean fke = false;
    private g.a fkf = new g.a();
    private c.a fkg = new 2(this);
    private int mSampleRate = 8000;

    public b(a aVar) {
        x.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + aVar);
        this.fkc = aVar;
        if (!com.tencent.mm.e.b.g.b.vw()) {
            x.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.fkc = a.gBX;
        }
        if (this.fkc == a.gBX) {
            this.fjO = 7;
            this.fka = new MediaRecorder();
        } else {
            vn();
            this.fjO = 1;
        }
        this.fke = false;
    }

    public final void a(b bVar) {
        if (this.fkc == a.gBX) {
            if (this.fka != null) {
                this.fjR = bVar;
                this.fka.setOnErrorListener(new OnErrorListener(this) {
                    final /* synthetic */ b fkh;

                    {
                        this.fkh = r1;
                    }

                    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                        if (this.fkh.fjR != null) {
                            this.fkh.fjR.onError();
                        }
                        try {
                            this.fkh.fka.release();
                        } catch (Exception e) {
                            x.e("MicroMsg.MMAudioRecorder", e.getMessage());
                        }
                        this.fkh.fkd = c.fkm;
                    }
                });
            }
        } else if (this.fkd == c.fkj) {
            this.fjR = bVar;
        } else {
            x.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
        }
    }

    public final void setOutputFile(String str) {
        if (this.fkc == a.gBX) {
            if (this.fka != null) {
                this.fka.setOutputFile(str);
                this.fjN = str;
            }
        } else if (this.fkd == c.fkj) {
            this.fjN = str;
        } else {
            x.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.fkd = c.fkm;
        }
    }

    public final void setMaxDuration(int i) {
        if (this.fkc != a.gBX) {
            this.fjU = (long) i;
        } else if (this.fka != null) {
            this.fka.setMaxDuration(i);
        }
    }

    public final void vk() {
        if (this.fkc == a.gBX && this.fka != null) {
            this.fka.setAudioEncoder(1);
        }
    }

    public final void vl() {
        if (this.fkc == a.gBX && this.fka != null) {
            this.fka.setAudioSource(1);
        }
    }

    public final void vm() {
        if (this.fkc == a.gBX && this.fka != null) {
            this.fka.setOutputFormat(3);
        }
    }

    public final int getMaxAmplitude() {
        if (this.fkc == a.gBX) {
            if (this.fka == null) {
                return 0;
            }
            return this.fka.getMaxAmplitude();
        } else if (this.fkd != c.fkl) {
            return 0;
        } else {
            int i = this.fjM;
            this.fjM = 0;
            return i;
        }
    }

    public final void vn() {
        this.fjT = d$a.SK();
        if (this.fjT != null) {
            boolean z;
            d$a com_tencent_mm_be_d_a = this.fjT;
            if (1 == g.t("EnableSpeexVoiceUpload", 0)) {
                z = true;
            } else {
                x.d("upload", "type " + d.chatType);
                int SJ = com_tencent_mm_be_d_a.SJ();
                int SI = com_tencent_mm_be_d_a.SI();
                com.tencent.mm.kernel.g.Dk();
                Integer valueOf = Integer.valueOf(bh.e((Integer) com.tencent.mm.kernel.g.Dj().CU().get(16646145, null)));
                x.d("upload", "daycount " + com_tencent_mm_be_d_a.SJ() + "  count " + valueOf + " rate " + SI);
                if (valueOf.intValue() <= SJ && SI != 0 && an.isWifi(ac.getContext())) {
                    com.tencent.mm.kernel.g.Dk();
                    z = com_tencent_mm_be_d_a.fWf == 0 ? true : com_tencent_mm_be_d_a.fWf == bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(12290, null), 0);
                    x.d("upload", "fitSex " + com_tencent_mm_be_d_a.fWf + " " + z + " " + com_tencent_mm_be_d_a.fWf);
                    if (z && com_tencent_mm_be_d_a.SH()) {
                        int nextInt;
                        nextInt = com_tencent_mm_be_d_a.hPo.nextInt(SI);
                        x.d("upload", "luck " + nextInt);
                        if (nextInt == SI / 2) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            this.fjZ = z;
        }
        if (this.fkc == a.gBY) {
            this.mSampleRate = bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("VoiceSamplingRate"), 16000);
            this.fjY = bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("VoiceRate"), 16000);
            x.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[]{r3, Integer.valueOf(this.mSampleRate), r0, Integer.valueOf(this.fjY)});
        } else {
            if (this.fjZ) {
                this.mSampleRate = 16000;
            } else {
                this.mSampleRate = 8000;
            }
            com.tencent.mm.kernel.g.Dk();
            nextInt = bh.a((Integer) com.tencent.mm.kernel.g.Dj().gQd.get(27), 0);
            x.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + nextInt);
            if (nextInt == 1) {
                this.mSampleRate = 8000;
            }
        }
        this.fjM = 0;
        this.fjN = null;
        synchronized (this.fjP) {
            this.fjS = null;
            this.fjQ = null;
        }
        this.fjW = 0;
        try {
            synchronized (fjX) {
                this.fkb = new c(this.mSampleRate, 1, 0);
                this.fkb.aO(true);
                this.fkb.et(120);
                this.fkb.fkK = this.fkg;
            }
            this.fkd = c.fkj;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                x.e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                x.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.fkd = c.fkm;
        }
    }

    public final void start() {
        if (this.fkc != a.gBX) {
            x.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.fkd + " recMode: " + this.fkc);
            if (this.fkd == c.fkk) {
                this.fjV = System.currentTimeMillis();
                this.fjW = 0;
                this.fkd = c.fkl;
                synchronized (fjX) {
                    this.fkb.vr();
                }
            } else {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().gQd.set(27, Integer.valueOf(1));
                x.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
                this.fkd = c.fkm;
            }
            this.fke = false;
        } else if (this.fka != null) {
            this.fka.start();
        }
    }

    public final void prepare() {
        if (this.fkc == a.gBX) {
            if (this.fka != null) {
                this.fka.prepare();
            }
        } else if (this.fkd != c.fkj || this.fjN == null) {
            this.fkd = c.fkm;
            release();
        } else {
            this.fkd = c.fkk;
        }
    }

    public final void release() {
        if (this.fkc != a.gBX) {
            if (this.fkd == c.fkl) {
                vo();
            } else {
                c cVar = c.fkk;
            }
            synchronized (fjX) {
                if (this.fkb != null) {
                    this.fkb.vi();
                    this.fkb.fkK = null;
                    this.fkb = null;
                }
            }
        } else if (this.fka != null) {
            this.fka.release();
        }
    }

    public final boolean vo() {
        if (this.fkc == a.gBX) {
            x.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", new Object[]{this.fka});
            if (this.fka != null) {
                this.fka.stop();
                this.fka.release();
                this.fka = null;
            }
            return true;
        }
        g.a aVar = new g.a();
        x.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.fkd);
        if (this.fkd != c.fkl) {
            x.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.fkd = c.fkm;
            return true;
        }
        synchronized (fjX) {
            if (this.fkb != null) {
                this.fke = true;
            } else {
                this.fke = false;
            }
        }
        long zi = aVar.zi();
        this.fkd = c.fkn;
        long zi2 = aVar.zi();
        if (this.fke) {
            x.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", new Object[]{Boolean.valueOf(this.fke)});
            int i = 0;
            while (this.fke) {
                i++;
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                }
                if (i >= 25) {
                    synchronized (fjX) {
                        x.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", new Object[]{this.fkb});
                        if (this.fkb != null) {
                            try {
                                this.fkb.vi();
                                this.fkb.fkK = null;
                                this.fkb = null;
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                            }
                        }
                    }
                    x.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", new Object[]{Boolean.valueOf(this.fke), Integer.valueOf(i)});
                }
            }
            x.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", new Object[]{Boolean.valueOf(this.fke), Integer.valueOf(i)});
        }
        synchronized (this.fjP) {
            if (this.fjQ != null) {
                this.fjQ.vE();
            }
            if (this.fjS != null) {
                com.tencent.mm.be.c cVar = this.fjS;
                x.i("MicroMsg.SpeexEncoderWorker", "stop ");
                new af(Looper.getMainLooper()).post(new 1(cVar));
            }
        }
        long bz = bh.bz(this.fjV);
        x.i("MicroMsg.MMAudioRecorder", "toNow " + bz + " startTickCnt: " + this.fjV + " pcmDataReadedCnt: " + this.fjW);
        if (bz > 2000 && this.fjW == 0) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().gQd.set(27, Integer.valueOf(1));
            x.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        x.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + zi + " Read:" + zi2 + " Thr:" + aVar.zi());
        return false;
    }
}
