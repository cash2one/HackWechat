package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements d {
    final /* synthetic */ AppBrandLivePusherView jlb;
    final /* synthetic */ c jlc;

    c$2(c cVar, AppBrandLivePusherView appBrandLivePusherView) {
        this.jlc = cVar;
        this.jlb = appBrandLivePusherView;
    }

    public final void afA() {
        j cN = this.jlb.jkT.cN(false);
        x.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[]{Integer.valueOf(cN.errorCode), cN.jlh});
    }
}
