package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import com.tencent.mm.ui.MMActivity;

class WebViewSearchContentInputFooter$7 implements Runnable {
    final /* synthetic */ WebViewSearchContentInputFooter tKR;

    WebViewSearchContentInputFooter$7(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.tKR = webViewSearchContentInputFooter;
    }

    public final void run() {
        MMActivity.showVKB((Activity) this.tKR.getContext());
    }
}
