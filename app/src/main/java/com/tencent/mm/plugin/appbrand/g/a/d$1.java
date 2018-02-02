package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

class d$1 implements JavaVoidCallback {
    final /* synthetic */ d jwb;

    d$1(d dVar) {
        this.jwb = dVar;
    }

    public final void invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array.length() > 0) {
            v8Array.toString();
        }
    }
}
