package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class n implements e {
    public String iPV = null;
    public String jKk = null;
    public String sgP = null;
    private String sgZ = null;
    public int sha = -1;
    public a shc = null;

    public n() {
        ar.CG().a(618, this);
        ar.CG().a(616, this);
        ar.CG().a(617, this);
    }

    public final void bFG() {
        ar.CG().a(new g(this.iPV), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 618) {
                this.iPV = ((e) kVar).lcJ;
                x.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[]{Boolean.valueOf(bh.ov(this.iPV))});
                if (!bh.ov(this.iPV)) {
                    bFG();
                }
            }
            if (kVar.getType() == 616) {
                g gVar = (g) kVar;
                this.sha = gVar.sgC;
                this.sgZ = gVar.sgB;
                x.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.sha), Boolean.valueOf(bh.ov(this.sgZ))});
                if (this.shc != null) {
                    this.shc.MA(this.sgZ);
                }
            }
            if (kVar.getType() == 617) {
                h hVar = (h) kVar;
                if (hVar.sgM == 0) {
                    x.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.sgP = hVar.sgP;
                    if (this.shc != null) {
                        this.shc.jb(true);
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.shc != null) {
                    this.shc.jb(false);
                }
            }
        } else if (i2 == -34 && kVar.getType() == 617) {
            x.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.shc != null) {
                this.shc.bFH();
            }
        } else if (this.shc != null) {
            this.shc.bFF();
        }
    }
}
