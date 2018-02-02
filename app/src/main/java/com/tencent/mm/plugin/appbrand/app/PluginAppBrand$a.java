package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.h.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.z.p;

final class PluginAppBrand$a extends p implements b {
    PluginAppBrand$a() {
        super(f.class);
    }

    public final void onAccountInitialized(c cVar) {
        super.onAccountInitialized(cVar);
        com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
        ((e) g.h(e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.h.b());
        ((e) g.h(e.class)).a("link_view_wxapp", new a());
        g.a(com.tencent.mm.plugin.appbrand.a.b.class, new d(j.iEs));
        g.a(r.class, new d((com.tencent.mm.kernel.c.a) f.u(com.tencent.mm.plugin.appbrand.appusage.e.class)));
        g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new d(new com.tencent.mm.plugin.appbrand.widget.d()));
    }

    public final void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.k(m.class));
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.k(com.tencent.mm.plugin.appbrand.a.c.class));
    }

    public final void onAccountRelease() {
        g.j(r.class);
        g.j(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        super.onAccountRelease();
        ((e) g.h(e.class)).Eo("link_view_wxapp");
        ((e) g.h(e.class)).Eo("link_view_wxapp");
    }
}
