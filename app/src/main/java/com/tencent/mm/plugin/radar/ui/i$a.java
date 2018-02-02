package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import b.c.a.a;
import b.c.b.f;
import b.i;

final class i$a extends f implements a<T> {
    final /* synthetic */ Activity pAv;
    final /* synthetic */ int pAw;

    i$a(Activity activity, int i) {
        this.pAv = activity;
        this.pAw = i;
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.pAv.findViewById(this.pAw);
        if (findViewById != null) {
            return findViewById;
        }
        throw new i("null cannot be cast to non-null type T");
    }
}
