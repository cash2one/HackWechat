package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;

class WebViewStubService$7 implements Runnable {
    final /* synthetic */ WebViewStubService tvE;
    final /* synthetic */ Intent val$intent;

    WebViewStubService$7(WebViewStubService webViewStubService, Intent intent) {
        this.tvE = webViewStubService;
        this.val$intent = intent;
    }

    public final void run() {
        this.tvE.startActivity(this.val$intent);
    }
}
