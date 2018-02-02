package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.sdk.f.e;

abstract class p implements k {
    private volatile k$b jxT;
    final o jxU;

    public abstract String ahX();

    public abstract void prepare();

    p(o oVar) {
        this.jxU = oVar;
    }

    final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        k$b com_tencent_mm_plugin_appbrand_launching_k_b = this.jxT;
        if (com_tencent_mm_plugin_appbrand_launching_k_b != null) {
            com_tencent_mm_plugin_appbrand_launching_k_b.b(wxaPkgWrappingInfo);
        }
    }

    public final void a(k$b com_tencent_mm_plugin_appbrand_launching_k_b) {
        this.jxT = com_tencent_mm_plugin_appbrand_launching_k_b;
    }

    public final void prepareAsync() {
        e.post(new 1(this), "AppBrandLaunchPrepareJob#" + ahX());
    }
}
