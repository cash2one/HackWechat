package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1;
import com.tencent.mm.plugin.appbrand.dynamic.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements a {
    private a$c() {
    }

    public final void a(Bundle bundle, c cVar) {
        String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        String string2 = bundle.getString("appId");
        int i = bundle.getInt("wxaPkgType");
        int i2 = bundle.getInt("pkgVersion");
        int i3 = bundle.getInt("scene");
        String string3 = bundle.getString("searchId");
        int i4 = bundle.getInt("widgetType");
        int i5 = bundle.getInt("serviceType");
        String string4 = bundle.getString("preloadLaunchData", "");
        if (d.acE().rm(string) == null) {
            c cVar2 = new c(ac.getContext());
            d acE = d.acE();
            if (bh.ov(string)) {
                x.w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
            } else {
                if (((c) acE.iRX.put(string, cVar2)) != null) {
                    x.i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", new Object[]{string});
                }
                x.d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", new Object[]{string});
            }
        }
        f acG = f.acG();
        if (acG.iSb.containsKey(string)) {
            x.w("MicroMsg.DynamicPageViewStateMonitor", "OnAttach with same widgetId[%s]", new Object[]{string});
            acG.iSb.remove(string);
        }
        acG.iSb.put(string, new b(string, string2, i5));
        b.m(new 1(string, com.tencent.mm.plugin.appbrand.dynamic.k.a.bD(i4, i), i2, string2, i4, i3, string4, new 1(this, cVar), string3));
    }
}
