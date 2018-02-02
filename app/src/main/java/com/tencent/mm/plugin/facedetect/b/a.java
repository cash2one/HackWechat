package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements e {
    public boolean fmO = false;
    public int meK = -1;
    public d meL = null;
    public c meM = null;
    public boolean meN = false;
    public long meO = 0;
    public int meP = 0;
    public k meQ = null;
    public k meR = null;
    public long meS = -1;
    public int meT = -1;
    public i$a meU = new 1(this);

    public a(int i) {
        this.meK = i;
    }

    public final void aGe() {
        if (this.meR != null) {
            g.CG().b(this.meR.getType(), this);
        }
    }

    public final void g(int i, int i2, String str) {
        ag.y(new 2(this, i, i2, str));
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        x.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[]{kVar.toString(), Integer.valueOf(i), Integer.valueOf(i2), str});
        if ((kVar instanceof u) || (kVar instanceof v)) {
            if (i == 0 && i2 == 0) {
                b bVar = (b) kVar;
                this.meO = bVar.aGf();
                com.tencent.mm.plugin.facedetect.model.e.cR(this.meO);
                if (bVar.aGg() == null) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    g(2, 90015, "face motion config from server is null");
                    return;
                }
                byte[] aGg = bVar.aGg();
                String str2 = "MicroMsg.FaceUploadProcessor";
                String str3 = "configLen: %d, mUploadCallback == null: %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aGg.length);
                if (this.meL == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.i(str2, str3, objArr);
                if (this.meM != null) {
                    this.meM.e(this.meO, aGg);
                }
            } else if (this.meM != null) {
                this.meM.Y(i, "get face bio config failed");
            }
        } else if (this.meR != null && kVar.getType() == this.meR.getType()) {
            this.meT = (int) (System.currentTimeMillis() - this.meS);
            if (this.meL != null) {
                this.meL.h(i, i2, str, kVar);
            }
        }
    }
}
