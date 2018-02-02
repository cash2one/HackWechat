package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage.SendAppMessageTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.snackbar.b.c;

class GameJsApiSendAppMessage$SendAppMessageTask$1 implements c {
    final /* synthetic */ GameProcessActivityTask$a mVN;
    final /* synthetic */ SendAppMessageTask mXj;

    GameJsApiSendAppMessage$SendAppMessageTask$1(SendAppMessageTask sendAppMessageTask, GameProcessActivityTask$a gameProcessActivityTask$a) {
        this.mXj = sendAppMessageTask;
        this.mVN = gameProcessActivityTask$a;
    }

    public final void onShow() {
    }

    public final void onHide() {
        x.d("MicroMsg.GameJsApiSendAppMessage", "onHide");
        this.mVN.afh();
    }

    public final void aON() {
    }
}
