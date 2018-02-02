package com.tencent.pb.common.c;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a$w;
import com.tencent.pb.common.b.a.a.c;
import com.tencent.pb.common.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class f {
    private static Object sY = new Object();
    private static HashMap<String, String> zQn = new HashMap();

    public static void w(int i, int i2, String str) {
        if (str == null) {
            c.m("gyz", new Object[]{"addEmergencyRecord value is null"});
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            stringBuffer.append("---");
            stringBuffer.append(i2);
            synchronized (sY) {
                String str2 = (String) zQn.get(stringBuffer.toString());
                if (str2 != null && str2.length() > 0) {
                    StringBuffer stringBuffer2 = new StringBuffer(str2);
                    stringBuffer2.append("---");
                    stringBuffer2.append(str);
                    str = stringBuffer2.toString();
                }
                zQn.put(stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            c.m("gyz", new Object[]{th});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void ao(ArrayList<a$w> arrayList) {
        synchronized (sY) {
            Set keySet = zQn.keySet();
            if (keySet == null || keySet.size() <= 0) {
            }
        }
    }

    public static void aaS() {
        synchronized (sY) {
            zQn.clear();
        }
    }

    public static void cCU() {
        if (h.isNetworkConnected()) {
            e cVar;
            ArrayList arrayList = new ArrayList();
            ao(arrayList);
            if (arrayList.size() > 0) {
                cVar = new c();
                a$w[] com_tencent_pb_common_b_a_a_wArr = new a$w[arrayList.size()];
                arrayList.toArray(com_tencent_pb_common_b_a_a_wArr);
                cVar.zMN = com_tencent_pb_common_b_a_a_wArr;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                c.m("StatisticsUtil", new Object[]{"reportStatisticsData CSClientReportReq is null"});
                return;
            }
            c.m("yunying", new Object[]{"reportStatisticsData"});
            int a = com.tencent.pb.common.b.f.cCH().a(new 1(), "CsCmd.Cmd_CSClientReportReq", cVar);
            c.d("StatisticsUtil", new Object[]{"reportStatisticsData start ret: ", Integer.valueOf(a)});
            return;
        }
        c.m("StatisticsUtil", new Object[]{"reportStatisticsData network is false"});
    }
}
