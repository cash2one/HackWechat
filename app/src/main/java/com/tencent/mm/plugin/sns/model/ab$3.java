package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.sdk.platformtools.x;

class ab$3 implements Runnable {
    final /* synthetic */ aqc qVh;
    final /* synthetic */ ab qVi;

    ab$3(ab abVar, aqc com_tencent_mm_protocal_c_aqc) {
        this.qVi = abVar;
        this.qVh = com_tencent_mm_protocal_c_aqc;
    }

    public final void run() {
        this.qVh.wwQ++;
        try {
            x.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[]{Integer.valueOf(this.qVh.wwQ)});
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(this.qVi.qVd.rpt);
            com_tencent_mm_protocal_c_aqu.wyE = this.qVh;
            this.qVi.qVd.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
            ae.bvk().a(this.qVi.qVd.roJ, this.qVi.qVd);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[]{e.getMessage()});
        }
    }
}
