package com.tencent.mm.plugin.appbrand.g;

import android.webkit.ValueCallback;

class i$1 implements Runnable {
    final /* synthetic */ String iTQ;
    final /* synthetic */ ValueCallback iTR;
    final /* synthetic */ i jvU;

    i$1(i iVar, String str, ValueCallback valueCallback) {
        this.jvU = iVar;
        this.iTQ = str;
        this.iTR = valueCallback;
    }

    public final void run() {
        i.a(this.jvU).evaluateJavascript(this.iTQ, this.iTR);
    }
}
