package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;

class b$1 implements Runnable {
    final /* synthetic */ ValueCallback iTR;
    final /* synthetic */ String iTW;
    final /* synthetic */ b iTX;

    b$1(b bVar, String str, ValueCallback valueCallback) {
        this.iTX = bVar;
        this.iTW = str;
        this.iTR = valueCallback;
    }

    public final void run() {
        b.a(this.iTX, this.iTW, this.iTR);
    }
}
