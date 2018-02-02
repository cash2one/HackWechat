package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class GameWebViewMainProcessService$3 extends Handler {
    GameWebViewMainProcessService$3() {
    }

    public final void handleMessage(Message message) {
        GWMainProcessTask e = GameWebViewMainProcessService.e(message.getData(), false);
        GWMainProcessTask BE = GameWebViewMainProcessService.BE(e.jbo);
        if (BE == null) {
            x.e("MicroMsg.GameWebViewMainProcessService", "receive client msg, get null task by id %s", new Object[]{e.jbo});
            return;
        }
        GameWebViewMainProcessService.b(e, BE);
        BE.Ys();
    }
}
