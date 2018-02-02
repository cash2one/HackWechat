package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.d$b;
import com.tencent.mm.plugin.appbrand.config.d.a;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements a {
    final /* synthetic */ e irf;

    e$3(e eVar) {
        this.irf = eVar;
    }

    public final void a(d$b com_tencent_mm_plugin_appbrand_config_d_b, boolean z) {
        x.i("MicroMsg.AppBrandRuntime", "resume OnOrientationChanged orientation = [%s] success = [%b]", new Object[]{com_tencent_mm_plugin_appbrand_config_d_b, Boolean.valueOf(z)});
    }
}
