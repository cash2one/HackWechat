package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;

class WebViewUI$5 implements OnSystemUiVisibilityChangeListener {
    final /* synthetic */ WebViewUI tAv;
    final /* synthetic */ View tAw;

    WebViewUI$5(WebViewUI webViewUI, View view) {
        this.tAv = webViewUI;
        this.tAw = view;
    }

    public final void onSystemUiVisibilityChange(int i) {
        if ((i & 4) == 0 && this.tAv.tyw) {
            WebViewUI.cV(this.tAw);
        }
    }
}
