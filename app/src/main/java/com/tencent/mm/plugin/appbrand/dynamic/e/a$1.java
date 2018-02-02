package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;

class a$1 implements Runnable {
    final /* synthetic */ String iTQ;
    final /* synthetic */ ValueCallback iTR;
    final /* synthetic */ a iTS;

    a$1(a aVar, String str, ValueCallback valueCallback) {
        this.iTS = aVar;
        this.iTQ = str;
        this.iTR = valueCallback;
    }

    public final void run() {
        this.iTS.iTM.evaluateJavascript(this.iTQ, this.iTR);
    }
}
