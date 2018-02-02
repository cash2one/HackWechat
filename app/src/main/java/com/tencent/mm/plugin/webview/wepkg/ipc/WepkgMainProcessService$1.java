package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

class WepkgMainProcessService$1 extends Handler {
    final /* synthetic */ WepkgMainProcessService tMs;

    WepkgMainProcessService$1(WepkgMainProcessService wepkgMainProcessService, Looper looper) {
        this.tMs = wepkgMainProcessService;
        super(looper);
    }

    public final void handleMessage(Message message) {
        WepkgMainProcessTask ad = WepkgMainProcessService.ad(message.getData());
        Messenger messenger = message.replyTo;
        int i = message.what;
        ad.jbC = messenger;
        ad.mTaskId = i;
        ad.Yr();
    }
}
