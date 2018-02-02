package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class GameWebViewMainProcessService$1 extends Handler {
    final /* synthetic */ GameWebViewMainProcessService mVZ;

    GameWebViewMainProcessService$1(GameWebViewMainProcessService gameWebViewMainProcessService, Looper looper) {
        this.mVZ = gameWebViewMainProcessService;
        super(looper);
    }

    public final void handleMessage(Message message) {
        GameWebViewMainProcessService.e(message.getData(), true).Yr();
    }
}
