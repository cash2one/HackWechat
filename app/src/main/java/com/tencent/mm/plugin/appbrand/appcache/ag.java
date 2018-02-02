package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.debugger.b;
import com.tencent.mm.plugin.appbrand.debugger.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ag implements a {
    public static final Map<String, c> iGe;

    static /* synthetic */ void pK(String str) {
        if (f.Zo() == null) {
            x.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            return;
        }
        Map y = bi.y(str, "sysmsg");
        if (y == null || y.size() <= 0) {
            x.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            return;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", new Object[]{str2});
        if (!bh.ov(str2)) {
            c cVar = (c) iGe.get(str2);
            if (cVar != null) {
                cVar.u(y);
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b((byte) 0));
        hashMap.put("AppPublicLibraryNotify", new d((byte) 0));
        hashMap.put("mmbizwxaconfig", new a((byte) 0));
        hashMap.put("ForceOpenAppNotify", new c());
        hashMap.put("AppBrandForceKill", new b());
        iGe = Collections.unmodifiableMap(hashMap);
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        if (bh.ov(a)) {
            x.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
        } else {
            com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 1(this, a));
        }
    }
}
