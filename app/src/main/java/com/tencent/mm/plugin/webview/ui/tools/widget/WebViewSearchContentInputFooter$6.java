package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.text.Editable;
import android.text.TextWatcher;

class WebViewSearchContentInputFooter$6 implements TextWatcher {
    final /* synthetic */ WebViewSearchContentInputFooter tKR;

    WebViewSearchContentInputFooter$6(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.tKR = webViewSearchContentInputFooter;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (WebViewSearchContentInputFooter.c(this.tKR) != null) {
            WebViewSearchContentInputFooter$a c = WebViewSearchContentInputFooter.c(this.tKR);
            WebViewSearchContentInputFooter webViewSearchContentInputFooter = this.tKR;
            if (charSequence != null) {
                charSequence.toString();
            }
            c.a(webViewSearchContentInputFooter);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
