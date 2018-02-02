package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.share.e;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.base.n;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class i extends a {
    i() {
        super(m.jAI - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        boolean z = true;
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (!(appBrandSysConfig == null || context == null)) {
            if ((appBrandSysConfig.abX() & 64) > 0) {
                i$a aVar = new com.tencent.mm.plugin.appbrand.ui.a(context);
                aVar.YG(context.getString(j.iyS));
                aVar.mi(false);
                aVar.EC(j.iyK).a(new 1());
                aVar.akx().show();
            } else {
                z = false;
            }
        }
        if (!z) {
            AppBrandSysConfig appBrandSysConfig2 = pVar.irP.iqx;
            a aVar2 = new a();
            Map hashMap = new HashMap();
            hashMap.put("title", appBrandSysConfig2.frn);
            hashMap.put("desc", "");
            hashMap.put("path", pVar.jDS.iZW);
            hashMap.put("imgUrl", appBrandSysConfig2.iOg);
            aVar2.a(pVar).v(hashMap).afs();
            e.agL();
        }
    }
}
