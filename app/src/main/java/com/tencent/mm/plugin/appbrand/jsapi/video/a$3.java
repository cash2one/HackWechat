package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.p$d;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements p$d {
    final /* synthetic */ AppBrandVideoView jtm;
    final /* synthetic */ a jtn;

    a$3(a aVar, AppBrandVideoView appBrandVideoView) {
        this.jtn = aVar;
        this.jtm = appBrandVideoView;
    }

    public final void afA() {
        AppBrandVideoView appBrandVideoView = this.jtm;
        x.i("MicroMsg.AppBrandVideoView", "onUIPause");
        appBrandVideoView.jsj.TD();
    }
}
