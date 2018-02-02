package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.util.SparseIntArray;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.ReportTask;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.bct;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.sdk.platformtools.bh;

public final class AppBrandOpReportLogic$b {
    private static final SparseIntArray joT = new SparseIntArray();

    public static int sH(String str) {
        int i = 0;
        if (!bh.ov(str)) {
            synchronized (joT) {
                i = joT.get(str.hashCode(), 0);
            }
        }
        return i;
    }

    static void aC(String str, int i) {
        if (!bh.ov(str)) {
            synchronized (joT) {
                joT.put(str.hashCode(), i);
            }
        }
    }

    static void a(ReportTask reportTask) {
        if (reportTask != null) {
            a aVar = new a();
            aVar.hmi = 1345;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose";
            aVar.hmk = new bcu();
            String str = reportTask.appId;
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_bct = new bct();
            com_tencent_mm_protocal_c_bct.wIT = new apw();
            com_tencent_mm_protocal_c_bct.wIT.fFm = str;
            com_tencent_mm_protocal_c_bct.wIT.username = reportTask.username;
            com_tencent_mm_protocal_c_bct.wIT.wtc = reportTask.iKd;
            com_tencent_mm_protocal_c_bct.wIT.vNa = reportTask.fIm;
            com_tencent_mm_protocal_c_bct.wIT.rYW = reportTask.scene;
            com_tencent_mm_protocal_c_bct.wIT.wwA = reportTask.fIs;
            com_tencent_mm_protocal_c_bct.wIT.wwB = 1;
            com_tencent_mm_protocal_c_bct.wIT.wwC = reportTask.fnq;
            com_tencent_mm_protocal_c_bct.wIT.wwD = reportTask.jhr;
            com_tencent_mm_protocal_c_bct.wgV = reportTask.joU;
            aVar.hmj = com_tencent_mm_protocal_c_bct;
            u.a(aVar.JZ(), new 1(str), true);
        }
    }
}
