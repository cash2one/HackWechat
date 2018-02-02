package com.tencent.mm.plugin.appbrand.page;

import android.webkit.ValueCallback;

class t$3 implements Runnable {
    final /* synthetic */ String iTQ;
    final /* synthetic */ ValueCallback iTR;
    final /* synthetic */ t jFj;

    t$3(t tVar, String str, ValueCallback valueCallback) {
        this.jFj = tVar;
        this.iTQ = str;
        this.iTR = valueCallback;
    }

    public final void run() {
        t.a(this.jFj, this.iTQ, this.iTR);
    }
}
