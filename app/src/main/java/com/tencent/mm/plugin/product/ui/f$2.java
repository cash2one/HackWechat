package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ f pfL;
    final /* synthetic */ mf pfM;

    f$2(f fVar, mf mfVar) {
        this.pfL = fVar;
        this.pfM = mfVar;
    }

    public final void run() {
        x.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(this.pfM.fDU.errCode), Boolean.valueOf(this.pfM.fDU.fDV)});
        if (this.pfM.fDU.errCode == 0) {
            c c = f.c(this.pfL);
            mf mfVar = this.pfM;
            cb cbVar = new cb();
            cbVar.ksU = mfVar.fDU.userName;
            cbVar.vHm = mfVar.fDU.fDX;
            cbVar.vHn = mfVar.fDU.fDY;
            cbVar.hvu = mfVar.fDU.fDZ;
            cbVar.hvv = mfVar.fDU.fEa;
            cbVar.hvC = mfVar.fDU.fEb;
            cbVar.ngs = mfVar.fDU.fEc;
            if (!(bh.ov(cbVar.ksU) || bh.ov(cbVar.vHm))) {
                c.pdQ = cbVar;
            }
        }
        f.d(this.pfL);
    }
}
