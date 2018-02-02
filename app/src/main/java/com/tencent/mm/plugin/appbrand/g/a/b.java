package com.tencent.mm.plugin.appbrand.g.a;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

abstract class b {
    private final String ibD;

    protected abstract void a(f fVar, V8Object v8Object);

    b() {
        this("");
    }

    b(String str) {
        this.ibD = str;
    }

    final b a(f fVar) {
        if (TextUtils.isEmpty(this.ibD)) {
            a(fVar, fVar.jwm);
        } else {
            V8Value v8Object = new V8Object(fVar.jwm);
            fVar.jwm.add(this.ibD, v8Object);
            a(fVar, v8Object);
        }
        return this;
    }
}
