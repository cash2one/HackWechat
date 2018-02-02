package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.launching.j.a;
import java.util.Locale;

final class j$a$a {
    String jxM;
    String jxN;

    j$a$a() {
    }

    final j$a$a f(String str, Object... objArr) {
        this.jxM = String.format(Locale.US, str, objArr);
        return this;
    }

    final j$a$a g(String str, Object... objArr) {
        this.jxN = String.format(Locale.US, str, objArr);
        return this;
    }

    final a ahV() {
        return new a(this.jxN, this.jxM);
    }
}
