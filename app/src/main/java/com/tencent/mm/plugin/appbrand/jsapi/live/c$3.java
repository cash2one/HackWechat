package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class c$3 extends b {
    final /* synthetic */ p jdJ;
    final /* synthetic */ AppBrandLivePusherView jlb;
    final /* synthetic */ c jlc;

    c$3(c cVar, AppBrandLivePusherView appBrandLivePusherView, p pVar) {
        this.jlc = cVar;
        this.jlb = appBrandLivePusherView;
        this.jdJ = pVar;
    }

    public final void a(c cVar) {
        AppBrandLivePusherView appBrandLivePusherView = this.jlb;
        x.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[]{cVar});
        if (cVar == c.iqk || cVar == c.iqj || cVar == c.iqp) {
            appBrandLivePusherView.jkT.cN(true);
        }
    }

    public final void onResume() {
        this.jlb.jkT.agv();
    }

    public final void onDestroy() {
        com.tencent.mm.plugin.appbrand.c.b(this.jdJ.mAppId, this);
    }
}
