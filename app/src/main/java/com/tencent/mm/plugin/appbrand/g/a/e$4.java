package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

class e$4 implements JavaVoidCallback {
    final /* synthetic */ e jwe;

    e$4(e eVar) {
        this.jwe = eVar;
    }

    public final void invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array.length() > 0 && v8Array.getType(0) == 1) {
            e.a(this.jwe, v8Array.getInteger(0));
        }
    }
}
