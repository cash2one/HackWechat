package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements y {
    final /* synthetic */ AppBrandVideoView jtm;
    final /* synthetic */ a jtn;

    a$1(a aVar, AppBrandVideoView appBrandVideoView) {
        this.jtn = aVar;
        this.jtm = appBrandVideoView;
    }

    public final void agt() {
        AppBrandVideoView appBrandVideoView = this.jtm;
        x.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
        if (appBrandVideoView.jsm.jsY) {
            appBrandVideoView.jsm.ags();
        }
        appBrandVideoView.cZ(false);
    }
}
