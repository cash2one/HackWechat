package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.jsapi.n;

class j$3 extends n {
    final /* synthetic */ j iXz;

    j$3(j jVar, float f) {
        this.iXz = jVar;
        super(f);
    }

    public final StringBuilder e(StringBuilder stringBuilder) {
        return stringBuilder.append("__WxNativeHandler__.__triggerTouchEvent__(");
    }

    public final StringBuilder f(StringBuilder stringBuilder) {
        return stringBuilder.append(");");
    }
}
