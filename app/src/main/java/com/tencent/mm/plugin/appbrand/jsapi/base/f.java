package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class f {
    int jcN;
    c jhl;

    f(c cVar, int i) {
        this.jhl = cVar;
        this.jcN = i;
    }

    public final void sj(String str) {
        this.jhl.E(this.jcN, str);
    }
}
