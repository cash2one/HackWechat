package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import java.nio.ByteBuffer;

class c$2 implements JavaCallback {
    final /* synthetic */ c jvZ;
    final /* synthetic */ f jwa;

    c$2(c cVar, f fVar) {
        this.jvZ = cVar;
        this.jwa = fVar;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
            return null;
        }
        ByteBuffer jt = this.jvZ.jvY.jt(v8Array.getInteger(0));
        if (jt != null) {
            return new V8ArrayBuffer(this.jwa.jwm, jt);
        }
        return null;
    }
}
