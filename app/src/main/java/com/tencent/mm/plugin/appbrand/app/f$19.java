package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class f$19 extends c<n> {
    final /* synthetic */ f iDI;

    f$19(f fVar) {
        this.iDI = fVar;
        this.xen = n.class.getName().hashCode();
    }

    private static boolean a(n nVar) {
        String str = nVar.fnn.fnl;
        String str2 = nVar.fnn.appId;
        int i = nVar.fnn.fno;
        int i2 = nVar.fnn.scene;
        String str3 = nVar.fnn.fnp;
        String str4 = nVar.fnn.fnq;
        int i3 = nVar.fnn.action;
        String str5 = nVar.fnn.fnr;
        long j = nVar.fnn.fns;
        int i4 = nVar.fnn.fnt;
        int i5 = nVar.fnn.fnu;
        int i6 = 3;
        if (!bh.ov(str)) {
            String str6 = "";
            if (!bh.ov(str4) && str4.contains(".html")) {
                str6 = str4.substring(0, str4.lastIndexOf(".html") + 5);
            }
            str4 = "";
            try {
                str4 = p.encode(bh.ou(str6), "UTF-8");
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
            }
            String ou = bh.ou(str3);
            str3 = bh.ou(str5);
            str5 = bh.ou(str2);
            int tX = a.tX(str2);
            if (i > 0) {
                i6 = i - 1;
                i6 = f.Zn().an(str, i6) ? 1 : f.Zm().ao(str, i6) ? 2 : 3;
            }
            x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", new Object[]{Integer.valueOf(13540), Integer.valueOf(i2), ou, str5, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str6, Integer.valueOf(i3), str3, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(tX)});
            g.pQN.h(13540, new Object[]{Integer.valueOf(i2), ou, str5, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str4, Integer.valueOf(i3), str3, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(tX)});
        }
        return true;
    }
}
