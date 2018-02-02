package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

class GameWebViewUI$b extends a {
    final /* synthetic */ GameWebViewUI tFJ;

    private GameWebViewUI$b(GameWebViewUI gameWebViewUI) {
        this.tFJ = gameWebViewUI;
        super(gameWebViewUI);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        GameWebViewUI.I(this.tFJ).tLv.b(webView, str, bitmap);
        super.b(webView, str, bitmap);
    }

    public final void a(WebView webView, String str) {
        GameWebViewUI.J(this.tFJ);
        GameWebViewUI.I(this.tFJ).tLv.a(webView, str);
        super.a(webView, str);
    }

    public final void a(WebView webView, int i, String str, String str2) {
        GameWebViewUI.J(this.tFJ);
        super.a(webView, i, str, str2);
    }

    public final m c(WebView webView, String str) {
        m c = GameWebViewUI.I(this.tFJ).tLv.c(webView, str);
        return c != null ? c : super.c(webView, str);
    }

    public final m a(WebView webView, l lVar) {
        m a = GameWebViewUI.I(this.tFJ).tLv.a(webView, lVar);
        return a != null ? a : super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        m a = GameWebViewUI.I(this.tFJ).tLv.a(webView, lVar, bundle);
        return a != null ? a : super.a(webView, lVar, bundle);
    }
}
