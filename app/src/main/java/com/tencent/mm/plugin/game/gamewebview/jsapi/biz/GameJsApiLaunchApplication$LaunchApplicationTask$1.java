package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.g.a.iq;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g.a;

class GameJsApiLaunchApplication$LaunchApplicationTask$1 implements a {
    final /* synthetic */ GameProcessActivityTask.a mVN;
    final /* synthetic */ iq mWR;
    final /* synthetic */ LaunchApplicationTask mWS;

    GameJsApiLaunchApplication$LaunchApplicationTask$1(LaunchApplicationTask launchApplicationTask, iq iqVar, GameProcessActivityTask.a aVar) {
        this.mWS = launchApplicationTask;
        this.mWR = iqVar;
        this.mVN = aVar;
    }

    public final void cG(boolean z) {
        if (this.mWR.fzb.fze || z) {
            this.mWS.success = true;
            this.mVN.afh();
        }
    }
}
