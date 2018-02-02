package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class WebViewInputFooter$1 implements OnClickListener {
    final /* synthetic */ WebViewInputFooter tLd;

    WebViewInputFooter$1(WebViewInputFooter webViewInputFooter) {
        this.tLd = webViewInputFooter;
    }

    public final void onClick(View view) {
        if (WebViewInputFooter.a(this.tLd) == 0) {
            WebViewInputFooter.b(this.tLd).aWs();
            if (!WebViewInputFooter.c(this.tLd)) {
                WebViewInputFooter.d(this.tLd).requestFocus();
            }
            WebViewInputFooter.e(this.tLd);
            WebViewInputFooter.f(this.tLd).setImageResource(R.k.dBc);
            WebViewInputFooter.a(this.tLd, 1);
            WebViewInputFooter.g(this.tLd);
            return;
        }
        WebViewInputFooter.g(this.tLd);
        WebViewInputFooter.d(this.tLd).requestFocus();
        WebViewInputFooter.b(this.tLd).showVKB();
        WebViewInputFooter.h(this.tLd);
        WebViewInputFooter.a(this.tLd, 0);
    }
}
