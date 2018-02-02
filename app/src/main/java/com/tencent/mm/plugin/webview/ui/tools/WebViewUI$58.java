package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.model.y.d;
import com.tencent.mm.ui.base.h;

class WebViewUI$58 implements d {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$58(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void Oi(String str) {
        WebViewUI.a(this.tAv, str, true, 9);
    }

    public final void goBack() {
        if (this.tAv.ptK != null && !WebViewUI.aD(this.tAv)) {
            if (this.tAv.ptK.canGoBack() && this.tAv.mZp) {
                this.tAv.bSG();
                return;
            }
            g.tyi.close();
            this.tAv.finish();
        }
    }

    public final void c(OnCancelListener onCancelListener) {
        if (WebViewUI.aL(this.tAv) != null) {
            WebViewUI.aL(this.tAv).dismiss();
        }
        WebViewUI.a(this.tAv, h.a(this.tAv, this.tAv.getString(R.l.ezF), true, onCancelListener));
    }

    public final void aCx() {
        if (WebViewUI.aL(this.tAv) != null) {
            WebViewUI.aL(this.tAv).dismiss();
        }
    }
}
