package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.debugger.p.7;
import com.tencent.mm.protocal.c.bwc;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class k$3 extends TimerTask {
    final /* synthetic */ k iQV;

    k$3(k kVar) {
        this.iQV = kVar;
    }

    public final void run() {
        if (this.iQV.iQx.isBusy() && this.iQV.acr()) {
            x.i("MicroMsg.RemoteDebugMsgMrg", "testServer");
        } else {
            this.iQV.acq();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.iQV.iQx.iQd >= 10000) {
                k kVar = this.iQV;
                a com_tencent_mm_protocal_c_bwc = new bwc();
                com_tencent_mm_protocal_c_bwc.wXj = kVar.iQx.iPU;
                com_tencent_mm_protocal_c_bwc.wXk = kVar.iQx.acj();
                kVar.iQA.a(o.a(1001, com_tencent_mm_protocal_c_bwc));
            }
            if (this.iQV.iQx.is() && currentTimeMillis - this.iQV.iQx.iQe >= 10000) {
                this.iQV.bB(this.iQV.iQx.acj(), 0);
            }
        }
        ag.y(new 7(this.iQV.iQC));
    }
}
