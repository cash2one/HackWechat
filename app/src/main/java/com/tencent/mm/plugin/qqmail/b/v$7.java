package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.qqmail.b.v.g;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class v$7 implements f {
    final /* synthetic */ v ppT;

    v$7(v vVar) {
        this.ppT = vVar;
    }

    public final void a(int i, int i2, k kVar) {
        x.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[]{this.ppT.ppM, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.ppT.ppL.size())});
        if (i >= i2) {
            this.ppT.ppO.put(this.ppT.ppN, ((o) kVar).bkm().vYg);
            bqi bkm = ((o) kVar).bkm();
            if (this.ppT.ppQ != null) {
                this.ppT.ppQ.c(this.ppT.ppR - this.ppT.ppL.size(), this.ppT.ppR, this.ppT.ppN, bkm.vYg);
            }
            if (this.ppT.ppL.isEmpty()) {
                x.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                if (this.ppT.ppP != null) {
                    this.ppT.ppP.bkp();
                    return;
                }
                return;
            }
            x.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
            g gVar = (g) this.ppT.ppL.remove(0);
            this.ppT.ppM = gVar.fzR;
            this.ppT.ppN = gVar.fileName;
            ar.CG().a(new o(this.ppT.ppN, this.ppT.ppM, this), 0);
        }
    }
}
