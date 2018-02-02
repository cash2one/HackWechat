package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a;
import com.tencent.mm.plugin.webview.wepkg.model.g;

class r$1 implements Runnable {
    final /* synthetic */ r mWK;
    final /* synthetic */ a mWu;

    r$1(r rVar, a aVar) {
        this.mWK = rVar;
        this.mWu = aVar;
    }

    public final void run() {
        g.a(new 1(this));
    }
}
