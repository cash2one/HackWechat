package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.z.b;

public final class AppBrandIDKeyBatchReport {
    private static volatile IDKeyBatchReportTask jGR;

    private static final class a {
        private static final byte[] jGS = new byte[0];

        static /* synthetic */ void b(cba com_tencent_mm_protocal_c_cba) {
            synchronized (jGS) {
                AppBrandIDKeyBatchReport.ajG().jGV = com_tencent_mm_protocal_c_cba;
                AppBrandIDKeyBatchReport.ajG().jGT = 3;
                AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.ajG());
            }
        }
    }

    public static IDKeyBatchReportTask ajG() {
        if (jGR == null) {
            jGR = new IDKeyBatchReportTask();
        }
        return jGR;
    }

    static String ajH() {
        if (g.Dh().Cy()) {
            String str = g.Dj().cachePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            str = str + "appbrand/report/";
            i.Qu(str);
            return str;
        }
        throw new b();
    }

    public static void a(cba com_tencent_mm_protocal_c_cba) {
        if (1086 != com_tencent_mm_protocal_c_cba.tlN) {
            if (ac.cfw()) {
                b.c(com_tencent_mm_protocal_c_cba);
            } else {
                a.b(com_tencent_mm_protocal_c_cba);
            }
        }
    }
}
