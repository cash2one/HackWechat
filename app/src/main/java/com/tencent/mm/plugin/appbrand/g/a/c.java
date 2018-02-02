package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;

final class c extends b {
    a jvY;

    c(a aVar) {
        this.jvY = aVar;
    }

    protected final void a(f fVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new JavaCallback(this) {
            final /* synthetic */ c jvZ;

            {
                this.jvZ = r1;
            }

            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                return Integer.valueOf(this.jvZ.jvY.ahL());
            }
        }, "getNativeBufferId");
        v8Object.registerJavaMethod(new 2(this, fVar), "getNativeBuffer");
        v8Object.registerJavaMethod(new JavaVoidCallback(this) {
            final /* synthetic */ c jvZ;

            {
                this.jvZ = r1;
            }

            public final void invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 10) {
                    V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) v8Array.get(1);
                    if (v8ArrayBuffer != null) {
                        this.jvZ.jvY.a(v8Array.getInteger(0), v8ArrayBuffer.getBackingStore());
                        v8ArrayBuffer.release();
                    }
                }
            }
        }, "setNativeBuffer");
    }
}
