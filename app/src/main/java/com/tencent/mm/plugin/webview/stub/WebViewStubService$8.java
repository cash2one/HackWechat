package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubService$8 implements a {
    final /* synthetic */ WebViewStubService tvE;

    WebViewStubService$8(WebViewStubService webViewStubService) {
        this.tvE = webViewStubService;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.WebViewStubService", "ServiceClick CGI return, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(i == 0 && i2 == 0)) {
            x.e("MicroMsg.WebViewStubService", "ServiceClick CGI fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
        return 0;
    }
}
