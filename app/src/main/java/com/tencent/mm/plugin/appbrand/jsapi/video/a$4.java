package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p$d;
import com.tencent.mm.plugin.appbrand.page.p$e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements p$e {
    final /* synthetic */ p jdJ;
    final /* synthetic */ f jkX;
    final /* synthetic */ p$d jkY;
    final /* synthetic */ AppBrandVideoView jtm;
    final /* synthetic */ a jtn;

    a$4(a aVar, AppBrandVideoView appBrandVideoView, p pVar, f fVar, p$d com_tencent_mm_plugin_appbrand_page_p_d) {
        this.jtn = aVar;
        this.jtm = appBrandVideoView;
        this.jdJ = pVar;
        this.jkX = fVar;
        this.jkY = com_tencent_mm_plugin_appbrand_page_p_d;
    }

    public final void onDestroy() {
        AppBrandVideoView appBrandVideoView = this.jtm;
        x.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
        appBrandVideoView.clean();
        this.jdJ.b(this.jkX);
        this.jdJ.b(this.jkY);
        this.jdJ.b(this);
    }
}
