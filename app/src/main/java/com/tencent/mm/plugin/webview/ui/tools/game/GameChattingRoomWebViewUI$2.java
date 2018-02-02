package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class GameChattingRoomWebViewUI$2 implements a {
    final /* synthetic */ GameChattingRoomWebViewUI tFf;

    GameChattingRoomWebViewUI$2(GameChattingRoomWebViewUI gameChattingRoomWebViewUI) {
        this.tFf = gameChattingRoomWebViewUI;
    }

    public final void a(boolean z, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", GameChattingRoomWebViewUI.b(this.tFf));
        this.tFf.setResult(GameChattingRoomWebViewUI.c(this.tFf), intent);
        this.tFf.finish();
    }
}
