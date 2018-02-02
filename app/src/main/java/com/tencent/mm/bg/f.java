package com.tencent.mm.bg;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bg.a.c$a;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Set;

public final class f implements e {
    public static int fmh = 5000;
    private static final String hYm = (w.gZK + "voice_temp.silk");
    private a fkK = new a(this) {
        short[] hYC;
        final /* synthetic */ f hYD;

        {
            this.hYD = r1;
        }

        public final void q(byte[] bArr, int i) {
            int i2 = 0;
            x.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            if (this.hYC == null || this.hYC.length < i / 2) {
                this.hYC = new short[(i / 2)];
            }
            while (i2 < i / 2) {
                this.hYC[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                i2++;
            }
            f.a(this.hYD, this.hYC, i / 2);
            if (this.hYD.hYA != null) {
                this.hYD.hYA.c(this.hYC, i / 2);
                return;
            }
            this.hYD.bq(9, -1);
            x.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        }

        public final void aK(int i, int i2) {
            x.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.hYD.bq(10, -1);
        }
    };
    private c fkb;
    private com.tencent.mm.bg.a.c hYA;
    private c$a hYB = new c$a(this) {
        final /* synthetic */ f hYD;
        byte[] hYE;

        {
            this.hYD = r1;
        }

        public final void a(short[] sArr, int i) {
            if (sArr != null) {
                int i2;
                if (this.hYE == null || this.hYE.length < i * 2) {
                    this.hYE = new byte[(i * 2)];
                }
                for (i2 = 0; i2 < i; i2++) {
                    this.hYE[i2 * 2] = (byte) (sArr[i2] & 255);
                    this.hYE[(i2 * 2) + 1] = (byte) ((sArr[i2] & 65280) >> 8);
                }
                if (this.hYD.hYu != null) {
                    i2 = this.hYD.hYu.a(new g.a(this.hYE, i * 2), 0, true);
                } else {
                    i2 = -1;
                }
                if (-1 == i2) {
                    this.hYD.bq(4, -1);
                    x.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                    return;
                }
                this.hYD.hYp = i2 + this.hYD.hYp;
                if (!this.hYD.hYy && this.hYD.hYp > 200 && !this.hYD.hYq) {
                    com.tencent.mm.kernel.g.Dm().F(new 1(this));
                    this.hYD.hYq = true;
                }
            }
        }

        public final void UV() {
            x.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
            if (this.hYD.hYw instanceof b) {
                try {
                    ((b) this.hYD.hYw).iN(com.tencent.mm.a.e.bN(f.hYm));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "cutShortSentence error", new Object[0]);
                    this.hYD.bq(6, -1);
                }
            }
        }

        public final void UW() {
            x.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
            if (this.hYD.hYw instanceof b) {
                try {
                    g gVar = ((b) this.hYD.hYw).hXV;
                    x.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
                    gVar.hYI.writeLock().lock();
                    g.a aVar = new g.a(gVar);
                    gVar.hYH.put(aVar.hYK, aVar);
                    gVar.hYI.writeLock().unlock();
                    if (!this.hYD.hYu.vF()) {
                        this.hYD.bq(5, -1);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "createShortSentence error", new Object[0]);
                    this.hYD.bq(6, -1);
                }
            }
        }

        public final void uY() {
            x.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", Long.valueOf(System.currentTimeMillis()));
            this.hYD.aL(false);
        }
    };
    public int hYo = 0;
    private int hYp = 0;
    private boolean hYq = false;
    private com.tencent.mm.e.c.a hYu;
    private a hYw = null;
    private boolean hYy = false;
    private b hYz = null;

    static /* synthetic */ void a(f fVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > fVar.hYo) {
                fVar.hYo = s;
            }
        }
        x.d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", Integer.valueOf(fVar.hYo));
    }

    public f(b bVar) {
        this.hYz = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String[] UM = ((a) kVar).UM();
        Set UO = ((a) kVar).UO();
        String str2 = "MicroMsg.SceneVoiceInputAddr";
        String str3 = "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(UM == null ? -1 : UM.length);
        objArr[4] = Integer.valueOf(kVar.hashCode());
        objArr[5] = Integer.valueOf(this.hYw == null ? -1 : this.hYw.hashCode());
        x.d(str2, str3, objArr);
        if (this.hYw == null || kVar.hashCode() != this.hYw.hashCode()) {
            x.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
        } else if (this.hYz == null) {
        } else {
            if (i2 == 0 && i == 0) {
                this.hYz.a(UM, UO);
                if ((kVar instanceof b) && this.hYp == 0 && ((b) kVar).hXV.UZ()) {
                    this.hYz.UX();
                    al(false);
                    return;
                }
                return;
            }
            if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                this.hYz.D(13, 132, -1);
            } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                this.hYz.D(11, i, i2);
            } else {
                this.hYz.D(13, d.CTRL_INDEX, -1);
            }
            al(false);
        }
    }

    public final void bq(int i, int i2) {
        x.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(-1));
        if (this.hYz != null) {
            this.hYz.D(i, i2, -1);
        }
        i(false, true);
    }

    public final void aL(boolean z) {
        x.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", Boolean.valueOf(z));
        if (!(z || this.hYz == null)) {
            this.hYz.UT();
        }
        i(true, true);
    }

    public final void al(boolean z) {
        x.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", Boolean.valueOf(z));
        this.hYz = null;
        i(false, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(boolean z, boolean z2) {
        x.i("MicroMsg.SceneVoiceInputAddr", "reset keepNetScene = %s,sendLastScene = %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        synchronized (this) {
            this.hYy = true;
            if (this.fkb != null) {
                this.fkb.vi();
                this.fkb = null;
            }
            if (this.hYu != null) {
                this.hYu.vE();
                this.hYu = null;
            }
            if (this.hYA != null) {
                try {
                    this.hYA.release();
                    this.hYA = null;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
                }
            }
            this.hYp = 0;
            if (this.hYw != null && (this.hYw instanceof b)) {
                this.hYw.UL();
                try {
                    ((b) this.hYw).iN(com.tencent.mm.a.e.bN(hYm));
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "reset cutShortSentence error", new Object[0]);
                    bq(6, -1);
                }
            }
            if (!z) {
                if (this.hYq) {
                    if (this.hYw != null && (this.hYw instanceof b)) {
                        x.i("MicroMsg.SceneVoiceInputAddr", "reset call stop() sendLastScene:%s", Boolean.valueOf(z2));
                        if (z2) {
                            ((b) this.hYw).UQ();
                        }
                        com.tencent.mm.kernel.g.CG().b(235, (e) this);
                    }
                    this.hYw = null;
                    this.hYq = false;
                }
            }
        }
    }
}
