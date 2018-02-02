package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8Object;

final class d extends b {
    public d() {
        super("console");
    }

    protected final void a(f fVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new 1(this), "log");
    }
}
