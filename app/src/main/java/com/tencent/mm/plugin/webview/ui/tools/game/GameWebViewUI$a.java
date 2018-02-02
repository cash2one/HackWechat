package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;

class GameWebViewUI$a extends h {
    final /* synthetic */ GameWebViewUI tFJ;

    private GameWebViewUI$a(GameWebViewUI gameWebViewUI) {
        this.tFJ = gameWebViewUI;
        super(gameWebViewUI);
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        Object onMiscCallBack = GameWebViewUI.I(this.tFJ).tLw.onMiscCallBack(str, bundle);
        return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
    }
}
