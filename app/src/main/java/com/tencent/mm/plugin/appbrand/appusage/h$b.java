package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.h.e;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.bs.a;
import java.util.Map;

public final class h$b implements a {
    private static final h$b iJB = new h$b();

    static /* synthetic */ void qa(String str) {
        x.i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", new Object[]{Boolean.valueOf(g.Dh().Cy()), str});
        if (g.Dh().Cy()) {
            Map y = bi.y(str, "sysmsg");
            if (y != null && y.size() > 0) {
                String str2 = (String) y.get(".sysmsg.wxareddot.id");
                int i = bh.getInt((String) y.get(".sysmsg.wxareddot.activitytype"), 0);
                if (!bh.ov(str2)) {
                    if (i == 1 || i == 2) {
                        int i2 = bh.getInt((String) y.get(".sysmsg.wxareddot.close"), 0);
                        long j = bh.getLong((String) y.get(".sysmsg.wxareddot.pushtime"), 0);
                        long j2 = bh.getLong((String) y.get(".sysmsg.wxareddot.duration"), 0);
                        long j3 = bh.getLong((String) y.get(".sysmsg.wxareddot.frequency"), 0);
                        y.get(".sysmsg.wxareddot.tips");
                        int i3 = bh.getInt((String) y.get(".sysmsg.wxareddot.showType"), 0);
                        int i4 = bh.getInt((String) y.get(".sysmsg.wxareddot.reason"), 0);
                        switch (i) {
                            case 1:
                                if (!str2.equals((String) g.Dj().CU().get(w.a.xrQ, null)) && !a.aaD() && !bh.by(ac.getContext()).equals(AppBrandLauncherUI.class.getName()) && g.aaN() != g.a.iJs) {
                                    g.Dj().CU().a(w.a.xrQ, str2);
                                    g.Dj().CU().a(w.a.xrR, Long.valueOf(j));
                                    g.Dj().CU().a(w.a.xrS, Integer.valueOf(i3));
                                    g.Dj().CU().a(w.a.xrT, Integer.valueOf(i4));
                                    if (i2 == 1 && h.aaW()) {
                                        e eVar = e.iJI;
                                        e.a((String) g.Dj().CU().get(w.a.xrQ, ""), ((Long) g.Dj().CU().get(w.a.xrR, Long.valueOf(0))).longValue(), 4, e.aba());
                                    }
                                    h.b(i2 != 1, j2);
                                    return;
                                }
                                return;
                            case 2:
                                if (!str2.equals((String) g.Dj().CU().get(w.a.xrX, null))) {
                                    h.b(i2 != 1, j2, j3);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private h$b() {
    }

    public static void aaZ() {
        g.aaL();
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("wxareddot", iJB, true);
    }

    public static void unregister() {
        g.aaL();
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("wxareddot", iJB, true);
    }

    public final void a(d.a aVar) {
        final String a = com.tencent.mm.platformtools.n.a(aVar.hmq.vGZ);
        if (!bh.ov(a)) {
            c.Dm().F(new Runnable(this) {
                final /* synthetic */ h$b iJC;

                public final void run() {
                    h$b.qa(a);
                }
            });
        }
    }
}
