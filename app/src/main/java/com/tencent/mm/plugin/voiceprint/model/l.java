package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class l implements e {
    public int sgJ;
    public int sgY;
    private String sgZ;
    public int sha;
    public a shb;

    public interface a {
        void My(String str);

        void Mz(String str);

        void bFF();

        void v(boolean z, int i);
    }

    public l() {
        this.sgY = 71;
        this.sgZ = null;
        this.sha = 0;
        this.sgJ = 0;
        this.shb = null;
        ar.CG().a(611, this);
        ar.CG().a(612, this);
    }

    public l(a aVar) {
        this();
        this.shb = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.sha = dVar.sgC;
                this.sgZ = dVar.sgB;
                x.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.sha), Boolean.valueOf(bh.ov(this.sgZ))});
                if (this.shb != null) {
                    if (this.sgY == 71) {
                        this.shb.My(this.sgZ);
                    } else if (this.sgY == 72) {
                        this.shb.Mz(this.sgZ);
                    }
                }
            }
            if (kVar.getType() == 612) {
                boolean z;
                f fVar = (f) kVar;
                if ((fVar.sgL == 72 && fVar.sgM == 0) || fVar.sgL == 71) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    x.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[]{Integer.valueOf(fVar.sgL)});
                    this.sgJ = fVar.sgJ;
                    if (this.shb != null) {
                        this.shb.v(true, fVar.sgL);
                    }
                } else {
                    x.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[]{Integer.valueOf(fVar.sgL)});
                    if (this.shb != null) {
                        this.shb.v(false, fVar.sgL);
                    }
                }
                if (z && fVar.sgL == 71 && this.shb != null) {
                    this.shb.Mz(this.sgZ);
                }
            }
        } else if (this.shb != null) {
            this.shb.bFF();
        }
    }
}
