package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements f {
    final /* synthetic */ AppBrandLivePlayerView jkV;
    final /* synthetic */ b jkW;

    b$2(b bVar, AppBrandLivePlayerView appBrandLivePlayerView) {
        this.jkW = bVar;
        this.jkV = appBrandLivePlayerView;
    }

    public final void aga() {
        l lVar = this.jkV.jkO;
        j ss = (lVar.jlp && lVar.jlv) ? lVar.ss("resume") : new j();
        x.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[]{Integer.valueOf(ss.errorCode), ss.jlh});
    }
}
