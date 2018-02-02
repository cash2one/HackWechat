package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.p$f;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements p$f {
    final /* synthetic */ AppBrandLivePusherView jlb;
    final /* synthetic */ c jlc;

    c$1(c cVar, AppBrandLivePusherView appBrandLivePusherView) {
        this.jlc = cVar;
        this.jlb = appBrandLivePusherView;
    }

    public final void aga() {
        j agv = this.jlb.jkT.agv();
        x.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[]{Integer.valueOf(agv.errorCode), agv.jlh});
    }
}
