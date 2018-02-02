package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.sdk.platformtools.x;

class WxaWidgetInitializer$1$1 implements e {
    final /* synthetic */ d iSn;
    final /* synthetic */ 1 iSo;

    WxaWidgetInitializer$1$1(1 1, d dVar) {
        this.iSo = 1;
        this.iSn = dVar;
    }

    public final void Q(String str, boolean z) {
        boolean z2 = false;
        WxaWidgetContext wxaWidgetContext = null;
        x.d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[]{this.iSo.uR, Integer.valueOf(this.iSo.iCP), Integer.valueOf(this.iSo.iSi), str, Boolean.valueOf(z)});
        if (z) {
            WxaPkgWrappingInfo a = a.a(this.iSo.uR, str, this.iSo.iSm, this.iSo.iCP, 0);
            if (a != null) {
                wxaWidgetContext = WxaWidgetInitializer.a(this.iSo.uR, str, a, this.iSn);
            } else {
                z = false;
            }
        }
        if (this.iSo.iSl != null) {
            WxaWidgetInitializer.a aVar = this.iSo.iSl;
            String str2 = this.iSo.uR;
            if (z && wxaWidgetContext != null) {
                z2 = true;
            }
            aVar.a(str2, str, z2, wxaWidgetContext);
        }
    }
}
