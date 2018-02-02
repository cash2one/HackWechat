package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

class i$2 implements JavaVoidCallback {
    final /* synthetic */ i jwF;
    final /* synthetic */ int val$id;

    i$2(i iVar, int i) {
        this.jwF = iVar;
        this.val$id = i;
    }

    public final void invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array.length() > 0 && v8Array.getType(0) == 4) {
            this.jwF.isd.z(this.val$id, v8Array.getString(0));
        }
    }
}
