package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class g$69 implements Runnable {
    final /* synthetic */ WebViewJSSDKFileItem tIY;
    final /* synthetic */ g tIj;

    g$69(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem) {
        this.tIj = gVar;
        this.tIY = webViewJSSDKFileItem;
    }

    public final void run() {
        b fcVar = new fc();
        fcVar.fua.op = 2;
        fcVar.fua.filePath = this.tIY.iLu;
        a.xef.m(fcVar);
        g.C(this.tIj);
    }
}
