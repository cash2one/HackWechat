package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qe;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.platformtools.x;

class ab$1 implements Runnable {
    final /* synthetic */ qe qVg;
    final /* synthetic */ aqc qVh;
    final /* synthetic */ ab qVi;

    ab$1(ab abVar, qe qeVar, aqc com_tencent_mm_protocal_c_aqc) {
        this.qVi = abVar;
        this.qVg = qeVar;
        this.qVh = com_tencent_mm_protocal_c_aqc;
    }

    public final void run() {
        x.i("MicroMsg.SightCdnUpload", "event callback errcode %d", Integer.valueOf(this.qVg.fHO.result));
        if (this.qVg.fHO.result >= 0) {
            ab.a(this.qVi);
            this.qVi.a(this.qVh);
            return;
        }
        this.qVi.onError();
    }
}
