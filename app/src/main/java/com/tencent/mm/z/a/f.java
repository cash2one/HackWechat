package com.tencent.mm.z.a;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    private static void ig(String str) {
        x.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[]{str});
        if (g.Ij().Ih()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra("content", str);
            ac.getContext().sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
            return;
        }
        x.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    }

    private static void a(e eVar, boolean z) {
        if (eVar == null || !g.Ij().Ih()) {
            x.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? stringBuilder.append("TestPointStart:") : stringBuilder.append("TestPointEnd:"));
        stringBuilder.append(g.Ij().hig.hic);
        stringBuilder.append("_");
        stringBuilder.append(eVar.id);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hii);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hii);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hij);
        stringBuilder.append("_");
        stringBuilder.append(eVar.result);
        stringBuilder.append("_");
        stringBuilder.append(eVar.hil);
        ig(stringBuilder.toString());
    }

    public static void a(e eVar) {
        if (eVar != null && g.Ij().Ih()) {
            String str = g.Ij().hig.hic;
            String str2 = eVar.id;
            String str3 = eVar.id;
            String str4 = (eVar.endTime - eVar.startTime);
            String str5 = eVar.result;
            String str6 = eVar.hii;
            long j = eVar.hil;
            x.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[]{str, str2, str6, str3, str4, str5, Long.valueOf(j)});
            g.pQN.h(11394, new Object[]{str, str2, str6, str3, str4, str5, Long.valueOf(j)});
        }
    }

    public static void ih(String str) {
        x.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        ig("TestCaseID:" + str);
    }

    public static void ii(String str) {
        if (g.Ij().ie(str) != null) {
            x.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[]{str});
            g.Ij().ie(str).hij = System.currentTimeMillis();
            g.Ij().ie(str).startTime = System.currentTimeMillis();
            g.Ij().ie(str).hik = false;
            g.Ij().ie(str).result = "0";
            a(g.Ij().ie(str), true);
        }
    }

    public static void ij(String str) {
        if (g.Ij().ie(str) != null && !g.Ij().ie(str).hik) {
            x.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[]{str});
            g.Ij().ie(str).hij = System.currentTimeMillis();
            g.Ij().ie(str).endTime = System.currentTimeMillis();
            g.Ij().ie(str).hik = true;
            a(g.Ij().ie(str));
            a(g.Ij().ie(str), false);
        }
    }
}
