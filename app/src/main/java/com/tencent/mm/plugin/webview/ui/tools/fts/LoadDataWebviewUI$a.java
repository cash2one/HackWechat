package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.xweb.WebView;

protected class LoadDataWebviewUI$a extends i {
    final /* synthetic */ LoadDataWebviewUI tDX;

    protected LoadDataWebviewUI$a(LoadDataWebviewUI loadDataWebviewUI) {
        this.tDX = loadDataWebviewUI;
        super(loadDataWebviewUI);
    }

    public void b(WebView webView, String str, Bitmap bitmap) {
        e.post(new 1(this, webView, str, bitmap), "LoadDataWebviewClient_onPageStarted");
    }

    public void a(WebView webView, String str) {
        e.post(new 2(this, webView, str), "LoadDataWebviewClient_onPageStarted");
    }
}
