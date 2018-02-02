package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.bcu;

class AppBrandOpReportLogic$b$1 implements a {
    final /* synthetic */ String fgU;

    AppBrandOpReportLogic$b$1(String str) {
        this.fgU = str;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0) {
            bcu com_tencent_mm_protocal_c_bcu = (bcu) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_bcu != null) {
                AppBrandOpReportLogic.b.aC(this.fgU, com_tencent_mm_protocal_c_bcu.wIU);
            }
        }
        return 0;
    }
}
