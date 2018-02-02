package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.model.aj.g;

class WebViewUI$8 implements OnClickListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$8(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onClick(View view) {
        this.tAv.j(WebViewUI.D(this.tAv), true, -1);
        g bRd = this.tAv.trN.bRd();
        bRd.tsX = new Object[]{this.tAv.fIG, Integer.valueOf(4)};
        bRd.c(this.tAv.juQ);
    }
}
