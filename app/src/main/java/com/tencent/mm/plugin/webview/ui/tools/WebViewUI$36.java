package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p.b;

class WebViewUI$36 implements b {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$36(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        String str = menuItem.getTitle();
        if (textView != null) {
            String str2 = (String) WebViewUI.X(this.tAv).get(str);
            if (bh.ov(str2)) {
                WebViewUI.c(textView, str);
            } else {
                textView.setText(i.b(this.tAv.mController.xIM, str2, textView.getTextSize()));
            }
        }
    }
}
