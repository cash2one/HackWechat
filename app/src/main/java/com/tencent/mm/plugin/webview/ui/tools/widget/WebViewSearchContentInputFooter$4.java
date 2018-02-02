package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.ui.MMActivity;

class WebViewSearchContentInputFooter$4 implements OnKeyListener {
    final /* synthetic */ WebViewSearchContentInputFooter tKR;

    WebViewSearchContentInputFooter$4(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.tKR = webViewSearchContentInputFooter;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (WebViewSearchContentInputFooter.c(this.tKR) != null) {
            WebViewSearchContentInputFooter.c(this.tKR).c(i, keyEvent);
        }
        if (i != 66 || WebViewSearchContentInputFooter.c(this.tKR) == null) {
            return false;
        }
        Context context = view.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).df(WebViewSearchContentInputFooter.d(this.tKR));
        }
        WebViewSearchContentInputFooter.c(this.tKR).b(this.tKR);
        return true;
    }
}
