package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.widget.Toast;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.4;
import com.tencent.mm.ui.tools.a.c.a;

class WebViewInputFooter$4$1 implements a {
    final /* synthetic */ 4 tLe;

    WebViewInputFooter$4$1(4 4) {
        this.tLe = 4;
    }

    public final void uY(String str) {
        if (WebViewInputFooter.k(this.tLe.tLd) != null) {
            WebViewInputFooter.k(this.tLe.tLd).BS(WebViewInputFooter.d(this.tLe.tLd).getText().toString());
        }
        WebViewInputFooter webViewInputFooter = this.tLe.tLd;
        webViewInputFooter.tKZ.clearComposingText();
        webViewInputFooter.tKZ.setText("");
    }

    public final void amI() {
    }

    public final void aem() {
        if (WebViewInputFooter.b(this.tLe.tLd) != null) {
            Toast.makeText(WebViewInputFooter.b(this.tLe.tLd), "exceed max-length", 0).show();
        }
    }
}
