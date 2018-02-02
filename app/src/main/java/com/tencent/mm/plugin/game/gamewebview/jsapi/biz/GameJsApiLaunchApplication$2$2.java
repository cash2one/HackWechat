package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.2;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.sdk.platformtools.x;

class GameJsApiLaunchApplication$2$2 implements Runnable {
    final /* synthetic */ 2 mWP;
    final /* synthetic */ LaunchApplicationTask mWQ;

    GameJsApiLaunchApplication$2$2(2 2, LaunchApplicationTask launchApplicationTask) {
        this.mWP = 2;
        this.mWQ = launchApplicationTask;
    }

    public final void run() {
        x.i("MicroMsg.GameJsApiLaunchApplication", "callback");
        if (this.mWQ.success) {
            a aVar = this.mWP.mWw;
            GameJsApiLaunchApplication gameJsApiLaunchApplication = this.mWP.mWO;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launchApplication:ok", null));
            return;
        }
        aVar = this.mWP.mWw;
        gameJsApiLaunchApplication = this.mWP.mWO;
        aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launchApplication:fail", null));
    }
}
