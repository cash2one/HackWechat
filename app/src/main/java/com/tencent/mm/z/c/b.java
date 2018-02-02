package com.tencent.mm.z.c;

import com.tencent.mm.ae.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    private static boolean Vx = false;

    static /* synthetic */ void F(List list) {
        if (bh.cA(list)) {
            x.w("MicroMsg.ABTestUpdater", "No expired Exp");
            return;
        }
        d IF = c.IF();
        if (!bh.cA(list)) {
            for (Integer num : list) {
                if (num != null) {
                    c cVar = new com.tencent.mm.storage.c();
                    cVar.field_expId = String.valueOf(num);
                    IF.a(cVar, "expId");
                }
            }
        }
        com.tencent.mm.storage.b IG = c.IG();
        if (!bh.cA(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    cVar = new a();
                    cVar.field_expId = String.valueOf(num2);
                    IG.a(cVar, new String[]{"expId"});
                }
            }
        }
    }

    static /* synthetic */ void G(List list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.ABTestUpdater", "No Exp");
            return;
        }
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (com.tencent.mm.bq.b a : list) {
            a.a im = a.im(n.a(a));
            linkedList.addAll(im.hiv);
            linkedList2.addAll(im.hiw);
        }
        c.IF().i(linkedList, 0);
        c.IG().i(linkedList2, 1);
    }

    static void Iz() {
        int i = 1;
        if (g.Dh().Cy()) {
            Long l = (Long) g.Dj().CU().get(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, null);
            long longValue = l == null ? 0 : l.longValue();
            int intValue;
            if (longValue == 0) {
                hb(new Random().nextInt(86400));
                IB();
                IC();
                x.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(intValue));
            } else {
                Integer num = (Integer) g.Dj().CU().get(w.a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, null);
                intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                long j = (long) intValue;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str = "MicroMsg.ABTestUpdater";
                String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(currentTimeMillis);
                x.i(str, str2, objArr);
                if (currentTimeMillis <= longValue + j) {
                    i = 0;
                }
            }
            if (i == 0) {
                x.v("MicroMsg.ABTestUpdater", "No need to update");
                return;
            } else if (Vx) {
                x.i("MicroMsg.ABTestUpdater", "Updating");
                return;
            } else {
                update();
                return;
            }
        }
        x.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
    }

    static void IA() {
        if (!g.Dh().Cy()) {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
        } else if (Vx) {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
        } else {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            update();
        }
    }

    private static void update() {
        Vx = true;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new xi();
        aVar.hmk = new xj();
        aVar.uri = "/cgi-bin/mmux-bin/getabtest";
        aVar.hmi = 1801;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        xi xiVar = (xi) JZ.hmg.hmo;
        Integer num = (Integer) g.Dj().CU().get(w.a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, null);
        xiVar.whX = num == null ? 0 : num.intValue();
        xiVar.whY = c.IF().chG();
        xiVar.whY.addAll(c.IG().chG());
        String str = "MicroMsg.ABTestUpdater";
        String str2 = "update abtest: %s";
        Object[] objArr = new Object[1];
        Iterator it = xiVar.whY.iterator();
        String str3 = "";
        while (it.hasNext()) {
            tf tfVar = (tf) it.next();
            str3 = str3 + tfVar.vYU + ":" + tfVar.priority + "|";
        }
        objArr[0] = str3;
        x.i(str, str2, objArr);
        u.a(JZ, new 1(), true);
    }

    private static void IB() {
        g.Dj().CU().a(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    private static void hb(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.Dj().CU().a(w.a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
    }

    private static void IC() {
        g.Dj().CU().lH(true);
    }
}
