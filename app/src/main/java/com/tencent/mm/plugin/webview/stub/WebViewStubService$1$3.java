package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class WebViewStubService$1$3 implements Runnable {
    final /* synthetic */ 1 tvH;
    final /* synthetic */ int tvI;
    final /* synthetic */ int tvJ;

    WebViewStubService$1$3(1 1, int i, int i2) {
        this.tvH = 1;
        this.tvI = i;
        this.tvJ = i2;
    }

    public final void run() {
        ar.Hg();
        c.CU().set(this.tvI, Integer.valueOf(this.tvJ));
    }
}
