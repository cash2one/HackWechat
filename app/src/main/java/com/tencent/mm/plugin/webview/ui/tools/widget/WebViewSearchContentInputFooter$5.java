package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.ui.MMActivity;

class WebViewSearchContentInputFooter$5 implements OnFocusChangeListener {
    final /* synthetic */ WebViewSearchContentInputFooter tKR;

    WebViewSearchContentInputFooter$5(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.tKR = webViewSearchContentInputFooter;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!(z || WebViewSearchContentInputFooter.c(this.tKR) == null)) {
            Context context = view.getContext();
            if (context instanceof MMActivity) {
                ((MMActivity) context).df(WebViewSearchContentInputFooter.d(this.tKR));
            }
        }
        WebViewSearchContentInputFooter.e(this.tKR).setSelected(z);
    }
}
