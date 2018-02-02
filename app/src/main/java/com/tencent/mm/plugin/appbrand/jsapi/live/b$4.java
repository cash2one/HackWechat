package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p$d;
import com.tencent.mm.plugin.appbrand.page.p$e;
import com.tencent.mm.plugin.appbrand.page.p.f;

class b$4 implements p$e {
    final /* synthetic */ p jdJ;
    final /* synthetic */ AppBrandLivePlayerView jkV;
    final /* synthetic */ b jkW;
    final /* synthetic */ f jkX;
    final /* synthetic */ p$d jkY;

    b$4(b bVar, AppBrandLivePlayerView appBrandLivePlayerView, p pVar, f fVar, p$d com_tencent_mm_plugin_appbrand_page_p_d) {
        this.jkW = bVar;
        this.jkV = appBrandLivePlayerView;
        this.jdJ = pVar;
        this.jkX = fVar;
        this.jkY = com_tencent_mm_plugin_appbrand_page_p_d;
    }

    public final void onDestroy() {
        this.jkV.sW();
        this.jdJ.b(this.jkX);
        this.jdJ.b(this.jkY);
        this.jdJ.b(this);
    }
}
