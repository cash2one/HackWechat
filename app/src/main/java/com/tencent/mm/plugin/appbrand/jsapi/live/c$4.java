package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;

class c$4 implements e {
    final /* synthetic */ p jdJ;
    final /* synthetic */ f jkX;
    final /* synthetic */ d jkY;
    final /* synthetic */ AppBrandLivePusherView jlb;
    final /* synthetic */ c jlc;
    final /* synthetic */ b jld;

    c$4(c cVar, AppBrandLivePusherView appBrandLivePusherView, p pVar, f fVar, d dVar, b bVar) {
        this.jlc = cVar;
        this.jlb = appBrandLivePusherView;
        this.jdJ = pVar;
        this.jkX = fVar;
        this.jkY = dVar;
        this.jld = bVar;
    }

    public final void onDestroy() {
        this.jlb.sW();
        this.jdJ.b(this.jkX);
        this.jdJ.b(this.jkY);
        this.jdJ.b((e) this);
        c.b(this.jdJ.mAppId, this.jld);
    }
}
