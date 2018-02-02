package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements y {
    final /* synthetic */ AppBrandLivePlayerView jkV;
    final /* synthetic */ b jkW;

    b$1(b bVar, AppBrandLivePlayerView appBrandLivePlayerView) {
        this.jkW = bVar;
        this.jkV = appBrandLivePlayerView;
    }

    public final void agt() {
        AppBrandLivePlayerView appBrandLivePlayerView = this.jkV;
        x.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
        appBrandLivePlayerView.cM(false);
    }
}
