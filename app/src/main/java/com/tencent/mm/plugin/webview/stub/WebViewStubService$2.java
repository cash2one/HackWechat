package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubService$2 extends c<mr> {
    final /* synthetic */ WebViewStubService tvE;

    WebViewStubService$2(WebViewStubService webViewStubService) {
        this.tvE = webViewStubService;
        this.xen = mr.class.getName().hashCode();
    }

    private boolean a(mr mrVar) {
        if ((mrVar instanceof mr) && (WebViewStubService.g(this.tvE) == null || WebViewStubService.g(this.tvE).containsKey(mrVar.fED.filePath))) {
            if (WebViewStubService.g(this.tvE) != null) {
                WebViewStubService.g(this.tvE).remove(mrVar.fED.filePath);
            }
            x.d("MicroMsg.WebViewStubService", "result: " + mrVar.fED.result);
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.f(this.tvE)) {
                    webViewStubCallbackWrapper.tyk.e(mrVar.fED.filePath, mrVar.fED.result, mrVar.fED.fqb, mrVar.fED.fqc);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewStubService", e, "", new Object[0]);
            }
        }
        return false;
    }
}
