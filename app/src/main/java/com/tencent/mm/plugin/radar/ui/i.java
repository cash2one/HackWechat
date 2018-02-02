package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import b.b;
import b.c.a.a;
import b.c.b.e;
import b.d;
import b.f;
import b.g;
import b.h;
import b.l;

public final class i {
    public static final <T extends View> b<T> C(View view, int i) {
        e.i(view, "$receiver");
        return a(new b(view, i));
    }

    static final <T> b<T> a(a<? extends T> aVar) {
        b.e eVar = b.e.AuC;
        e.i(eVar, "mode");
        e.i(aVar, "initializer");
        switch (d.pxK[eVar.ordinal()]) {
            case 1:
                return new h(aVar);
            case 2:
                return new g(aVar);
            case 3:
                return new l(aVar);
            default:
                throw new f();
        }
    }
}
