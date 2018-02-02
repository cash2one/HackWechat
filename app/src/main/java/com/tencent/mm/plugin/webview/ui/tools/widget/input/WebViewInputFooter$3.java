package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.KeyEvent;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;

class WebViewInputFooter$3 implements a {
    final /* synthetic */ WebViewInputFooter tLd;

    WebViewInputFooter$3(WebViewInputFooter webViewInputFooter) {
        this.tLd = webViewInputFooter;
    }

    public final void append(String str) {
        try {
            if (WebViewInputFooter.c(this.tLd)) {
                WebViewInputFooter.j(this.tLd).uX(str);
            } else {
                this.tLd.tKZ.aak(str);
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
        }
    }

    public final void amZ() {
        if (WebViewInputFooter.c(this.tLd) && WebViewInputFooter.j(this.tLd) != null) {
            WebViewInputFooter.j(this.tLd).uX("[DELETE_EMOTION]");
        } else if (WebViewInputFooter.d(this.tLd) != null) {
            MMEditText d = WebViewInputFooter.d(this.tLd);
            if (d.ztO != null) {
                d.ztO.sendKeyEvent(new KeyEvent(0, 67));
                d.ztO.sendKeyEvent(new KeyEvent(1, 67));
                return;
            }
            d.dispatchKeyEvent(new KeyEvent(0, 67));
            d.dispatchKeyEvent(new KeyEvent(1, 67));
        }
    }
}
