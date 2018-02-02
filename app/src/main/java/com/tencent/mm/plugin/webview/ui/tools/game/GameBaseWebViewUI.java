package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI extends WebViewUI {
    private c mZw = new 1(this);
    protected a tEZ;

    protected class a extends i {
        final /* synthetic */ GameBaseWebViewUI tFa;

        protected a(GameBaseWebViewUI gameBaseWebViewUI) {
            this.tFa = gameBaseWebViewUI;
            super(gameBaseWebViewUI);
        }

        public void b(WebView webView, String str, Bitmap bitmap) {
            this.tFa.mZw.tFt.bUg();
            super.b(webView, str, bitmap);
        }

        public void a(WebView webView, String str) {
            super.a(webView, str);
            this.tFa.mZw.tFt.bUh();
        }
    }

    protected final void T(Bundle bundle) {
        this.mZw.tFt.Z(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        this.mZw.tFt.onResume();
        if (this.tEZ != null) {
            this.tEZ.mZw.tFt.onResume();
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.mZw.tFt.onPause();
        if (this.tEZ != null) {
            this.tEZ.mZw.tFt.onPause();
        }
    }

    public void onDestroy() {
        c.a(this.mZw.tFt.tFu);
        if (this.tEZ != null) {
            this.tEZ.onDestroy();
        }
        super.onDestroy();
    }
}
