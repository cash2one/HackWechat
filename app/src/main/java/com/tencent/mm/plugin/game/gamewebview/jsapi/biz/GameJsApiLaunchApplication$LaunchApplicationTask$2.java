package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g.a;

class GameJsApiLaunchApplication$LaunchApplicationTask$2 implements a {
    final /* synthetic */ GameProcessActivityTask.a mVN;
    final /* synthetic */ LaunchApplicationTask mWS;

    GameJsApiLaunchApplication$LaunchApplicationTask$2(LaunchApplicationTask launchApplicationTask, GameProcessActivityTask.a aVar) {
        this.mWS = launchApplicationTask;
        this.mVN = aVar;
    }

    public final void cG(boolean z) {
        this.mWS.success = true;
        this.mVN.afh();
    }
}
