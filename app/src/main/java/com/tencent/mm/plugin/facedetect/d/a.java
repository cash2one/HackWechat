package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.c.d;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static final String mhl = (n.aGP() + File.separator + "fdv_v_");
    public static final String mhq = (h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    private com.tencent.mm.e.b.c.a fkK = new 2(this);
    c fkb;
    com.tencent.mm.bg.a.c hYA;
    private com.tencent.mm.bg.a.c.a hYB = new com.tencent.mm.bg.a.c.a(this) {
        final /* synthetic */ a mhs;

        {
            this.mhs = r1;
        }

        public final void a(short[] sArr, int i) {
            x.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[]{sArr, Integer.valueOf(i)});
        }

        public final void UV() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        }

        public final void UW() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (this.mhs.mhm != null) {
                this.mhs.mhm.aGT();
            }
        }

        public final void uY() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (this.mhs.mhm != null) {
                this.mhs.mhm.onError(11);
            }
        }
    };
    boolean hYW = true;
    private int hYo = 0;
    int hYp = 0;
    com.tencent.mm.e.c.a hYu;
    b mhm = null;
    boolean mhn = false;
    String mho = "";
    ArrayList<com.tencent.mm.e.b.c.a> mhp = new ArrayList(5);
    public com.tencent.mm.e.b.c.a mhr = new com.tencent.mm.e.b.c.a(this) {
        final /* synthetic */ a mhs;

        {
            this.mhs = r1;
        }

        public final void q(byte[] bArr, int i) {
            if (this.mhs.mhp != null) {
                Iterator it = this.mhs.mhp.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.e.b.c.a aVar = (com.tencent.mm.e.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.q(bArr, i);
                    }
                }
            }
        }

        public final void aK(int i, int i2) {
            if (this.mhs.mhp != null) {
                Iterator it = this.mhs.mhp.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.e.b.c.a aVar = (com.tencent.mm.e.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.aK(i, i2);
                    }
                }
            }
        }
    };

    private class a implements Runnable {
        final /* synthetic */ a mhs;
        private Runnable mht;

        private a(a aVar, Runnable runnable) {
            this.mhs = aVar;
            this.mht = null;
            this.mht = runnable;
        }

        public final void run() {
            synchronized (this.mhs) {
                if (this.mhs.mhn) {
                    x.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
                } else {
                    x.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                    this.mhs.mho = a.mhl + bh.Wq() + ".spx";
                    try {
                        new File(this.mhs.mho).delete();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "hy: delete file failed", new Object[0]);
                    }
                    this.mhs.fkb = new c(16000, 1, 3);
                    this.mhs.fkb.fkz = -19;
                    this.mhs.fkb.aO(false);
                    this.mhs.hYu = new d();
                    if (this.mhs.hYu.cL(this.mhs.mho)) {
                        if (q.gGe.gEQ > 0) {
                            this.mhs.fkb.n(q.gGe.gEQ, true);
                        } else {
                            this.mhs.fkb.n(5, false);
                        }
                        this.mhs.fkb.et(50);
                        this.mhs.fkb.aP(false);
                        try {
                            this.mhs.hYA = new com.tencent.mm.bg.a.c(5000, 16000, com.tencent.mm.bg.a.c.gZO.getInt("sil_time", 200), com.tencent.mm.bg.a.c.gZO.getFloat("s_n_ration", 2.5f), com.tencent.mm.bg.a.c.gZO.getInt("s_window", 50), com.tencent.mm.bg.a.c.gZO.getInt("s_length", 35), com.tencent.mm.bg.a.c.gZO.getInt("s_delay_time", 20), false, false);
                            this.mhs.hYA.hZf = this.mhs.hYB;
                        } catch (Throwable e2) {
                            x.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + e2.getMessage());
                            if (this.mhs.mhm != null) {
                                this.mhs.mhm.onError(6);
                            }
                        }
                        this.mhs.fkb.fkK = this.mhs.mhr;
                        this.mhs.a(this.mhs.fkK);
                        if (!this.mhs.fkb.vr()) {
                            x.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                            if (this.mhs.mhm != null) {
                                this.mhs.mhm.onError(7);
                            }
                        } else if (this.mht != null) {
                            this.mht.run();
                        }
                    } else {
                        x.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                        this.mhs.hYu.vE();
                        this.mhs.hYu = null;
                        if (this.mhs.mhm != null) {
                            this.mhs.mhm.onError(5);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > aVar.hYo) {
                aVar.hYo = s;
            }
        }
    }

    public final void aGS() {
        b.deleteFile(this.mho);
    }

    public final void a(com.tencent.mm.e.b.c.a aVar) {
        this.mhp.add(aVar);
    }
}
