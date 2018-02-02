package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.ArrayList;
import java.util.Map;

public final class m$a implements a {
    private static final m$a iJY = new m$a();

    static /* synthetic */ void qb(String str) {
        int i = 0;
        x.i("MicroMsg.AppBrandUsagePushingUpdateLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(g.Dh().Cy()), str);
        if (g.Dh().Cy()) {
            Map y = bi.y(str, "sysmsg");
            if (y != null && y.size() > 0) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                int i2;
                int i3 = bh.getInt((String) y.get(".sysmsg.UpdateWxaUsageListNotify.Type"), 0);
                int i4 = bh.getInt((String) y.get(".sysmsg.UpdateWxaUsageListNotify.DeleteCount"), 0);
                if (i4 > 0) {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (i5 < i4) {
                        String str2 = ".sysmsg.UpdateWxaUsageListNotify.DeleteList.DeleteAppInfo" + (i5 == 0 ? "" : Integer.valueOf(i5));
                        String str3 = (String) y.get(str2 + ".UserName");
                        String str4 = (String) y.get(str2 + ".AppID");
                        i2 = bh.getInt((String) y.get(str2 + ".AppType"), 0);
                        if (!(bh.ov(str3) || bh.ov(str4))) {
                            arrayList.add(str3);
                            arrayList2.add(str4);
                            arrayList3.add(Integer.valueOf(i2));
                        }
                        i5++;
                    }
                } else {
                    arrayList3 = null;
                    arrayList2 = null;
                    arrayList = null;
                }
                switch (i3) {
                    case 1:
                        new p(4, 1, Integer.MAX_VALUE, 30).JV();
                        return;
                    case 2:
                        new p(4, 2, 0, 0).JV();
                        return;
                    case 3:
                        if (!bh.cA(arrayList)) {
                            while (i < arrayList.size()) {
                                s.i((String) arrayList.get(i), (String) arrayList2.get(i), ((Integer) arrayList3.get(i)).intValue());
                                i++;
                            }
                            return;
                        }
                        return;
                    case 4:
                        if (!bh.cA(arrayList)) {
                            for (i2 = 0; i2 < arrayList.size(); i2++) {
                                f.Zn().h((String) arrayList.get(i2), ((Integer) arrayList3.get(i2)).intValue(), false);
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void aaZ() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", iJY, true);
    }

    public static void unregister() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", iJY, true);
    }

    public final void a(d.a aVar) {
        String a = com.tencent.mm.platformtools.n.a(aVar.hmq.vGZ);
        if (!bh.ov(a)) {
            c.Dm().F(new 1(this, a));
        }
    }
}
