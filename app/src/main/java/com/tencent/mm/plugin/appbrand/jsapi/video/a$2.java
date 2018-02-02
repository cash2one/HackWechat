package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements f {
    final /* synthetic */ AppBrandVideoView jtm;
    final /* synthetic */ a jtn;

    a$2(a aVar, AppBrandVideoView appBrandVideoView) {
        this.jtn = aVar;
        this.jtm = appBrandVideoView;
    }

    public final void aga() {
        AppBrandVideoView appBrandVideoView = this.jtm;
        x.i("MicroMsg.AppBrandVideoView", "onUIResume");
        appBrandVideoView.jsj.TE();
    }
}
