package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubProxyUI$7 implements a {
    final /* synthetic */ WebViewStubProxyUI tvs;

    WebViewStubProxyUI$7(WebViewStubProxyUI webViewStubProxyUI) {
        this.tvs = webViewStubProxyUI;
    }

    public final boolean uF() {
        if (this.tvs.getWindow() != null && this.tvs.getWindow().getDecorView() != null && this.tvs.getWindow().getDecorView().getWindowToken() != null) {
            WebViewStubProxyUI.e(this.tvs);
            WebViewStubProxyUI.f(this.tvs);
            return false;
        } else if (WebViewStubProxyUI.c(this.tvs) < 10) {
            WebViewStubProxyUI.d(this.tvs);
            return true;
        } else {
            x.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
            this.tvs.finish();
            return false;
        }
    }
}
