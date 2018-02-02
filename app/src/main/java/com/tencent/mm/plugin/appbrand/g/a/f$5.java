package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaVoidCallback;

class f$5 implements Runnable {
    final /* synthetic */ f jwq;
    final /* synthetic */ JavaVoidCallback jwt;
    final /* synthetic */ String jwu;

    f$5(f fVar, JavaVoidCallback javaVoidCallback, String str) {
        this.jwq = fVar;
        this.jwt = javaVoidCallback;
        this.jwu = str;
    }

    public final void run() {
        f.d(this.jwq).registerJavaMethod(this.jwt, this.jwu);
    }
}
