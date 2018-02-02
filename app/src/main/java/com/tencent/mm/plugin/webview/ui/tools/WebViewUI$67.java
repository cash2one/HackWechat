package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

class WebViewUI$67 implements OnApplyWindowInsetsListener {
    final /* synthetic */ ViewGroup nmu;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$67(WebViewUI webViewUI, ViewGroup viewGroup) {
        this.tAv = webViewUI;
        this.nmu = viewGroup;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.tAv.a(this.nmu, windowInsets);
        return windowInsets.consumeSystemWindowInsets();
    }
}
