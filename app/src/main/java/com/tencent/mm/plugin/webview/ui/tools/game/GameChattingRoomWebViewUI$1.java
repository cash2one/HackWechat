package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class GameChattingRoomWebViewUI$1 implements a {
    final /* synthetic */ GameChattingRoomWebViewUI tFf;

    GameChattingRoomWebViewUI$1(GameChattingRoomWebViewUI gameChattingRoomWebViewUI) {
        this.tFf = gameChattingRoomWebViewUI;
    }

    public final void a(boolean z, String str, int i) {
        this.tFf.setResult(GameChattingRoomWebViewUI.a(this.tFf), new Intent());
        this.tFf.finish();
    }
}
