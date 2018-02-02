package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.g.a;

class GameJsApiLaunchApplication$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ GameJsApiLaunchApplication mWO;
    final /* synthetic */ d mWr;

    GameJsApiLaunchApplication$1(GameJsApiLaunchApplication gameJsApiLaunchApplication, d dVar, int i) {
        this.mWO = gameJsApiLaunchApplication;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void cG(boolean z) {
        d dVar = this.mWr;
        int i = this.gOK;
        GameJsApiLaunchApplication gameJsApiLaunchApplication = this.mWO;
        dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launchApplication:ok", null));
    }
}
