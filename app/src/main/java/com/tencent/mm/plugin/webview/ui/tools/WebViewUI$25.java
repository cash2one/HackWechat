package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView.a;

class WebViewUI$25 implements OnLongClickListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$25(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean onLongClick(View view) {
        if (this.tAv.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
            return bTj();
        }
        return true;
    }

    private boolean bTj() {
        boolean cG;
        Exception e;
        boolean z;
        a hitTestResult = this.tAv.ptK.getHitTestResult();
        if (hitTestResult == null || bh.ov(hitTestResult.mExtra)) {
            x.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
            return false;
        }
        try {
            cG = this.tAv.juQ.cG(hitTestResult.mExtra);
            if (cG) {
                try {
                    this.tAv.juQ.cx(hitTestResult.mExtra, this.tAv.hashCode());
                } catch (Exception e2) {
                    e = e2;
                    x.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                    z = cG;
                    if (!z) {
                        return z;
                    }
                    WebViewUI.d(this.tAv, hitTestResult.mExtra);
                    return true;
                }
            }
            z = cG;
        } catch (Exception e3) {
            e = e3;
            cG = true;
            x.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
            z = cG;
            if (!z) {
                return z;
            }
            WebViewUI.d(this.tAv, hitTestResult.mExtra);
            return true;
        }
        if (!z) {
            return z;
        }
        WebViewUI.d(this.tAv, hitTestResult.mExtra);
        return true;
    }
}
