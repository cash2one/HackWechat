package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import b.c.a.a;
import b.c.b.f;
import b.i;

final class i$b extends f implements a<T> {
    final /* synthetic */ int pAw;
    final /* synthetic */ View pAx;

    i$b(View view, int i) {
        this.pAx = view;
        this.pAw = i;
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.pAx.findViewById(this.pAw);
        if (findViewById != null) {
            return findViewById;
        }
        throw new i("null cannot be cast to non-null type T");
    }
}
