package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h.a;

class WebViewInputFooter$4 implements OnClickListener {
    final /* synthetic */ WebViewInputFooter tLd;

    WebViewInputFooter$4(WebViewInputFooter webViewInputFooter) {
        this.tLd = webViewInputFooter;
    }

    public final void onClick(View view) {
        c GN = c.d(WebViewInputFooter.d(this.tLd)).GN(WebViewInputFooter.l(this.tLd));
        GN.jXW = a.zkT;
        GN.znM = true;
        GN.a(new 1(this));
    }
}
