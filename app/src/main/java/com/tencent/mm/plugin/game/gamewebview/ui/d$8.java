package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

class d$8 implements b {
    final /* synthetic */ d mZC;

    d$8(d dVar) {
        this.mZC = dVar;
    }

    public final void aPs() {
        this.mZC.qH(0);
    }

    public final void aPt() {
        WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.mZC.findViewById(R.h.cYR);
        if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.txF > 0) {
            this.mZC.qH(webViewKeyboardLinearLayout.txF);
        }
    }
}
