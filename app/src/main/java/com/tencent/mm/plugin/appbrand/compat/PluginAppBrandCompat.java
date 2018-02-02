package com.tencent.mm.plugin.appbrand.compat;

import android.support.annotation.Keep;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.plugin.appbrand.compat.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.n.c.a;

@Keep
public final class PluginAppBrandCompat extends f implements c, e {
    private final com.tencent.mm.sdk.b.c bannerOnInitListener = new 2(this);

    public final void installed() {
        super.installed();
        alias(e.class);
    }

    public final void configure(g gVar) {
    }

    public final void execute(g gVar) {
        if (gVar.DS()) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.f.class, new d(new com.tencent.mm.plugin.appbrand.l.d()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.d.class, new d(new b()));
            com.tencent.mm.kernel.g.Dk().a(new 1(this));
        } else {
            com.tencent.mm.kernel.g.a(a.class, new d(new com.tencent.mm.plugin.appbrand.jsapi.n.d()));
        }
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.a.class, new d(new a()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.c.class, new d(new k()));
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.bannerOnInitListener.ceO();
    }

    public final void onAccountRelease() {
        this.bannerOnInitListener.dead();
    }
}
