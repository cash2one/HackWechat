package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView$c;
import android.support.v7.widget.RecyclerView$e.a;

final class a$b extends RecyclerView$c implements a {
    final /* synthetic */ a jPj;

    private a$b(a aVar) {
        this.jPj = aVar;
    }

    public final void Z(int i, int i2) {
        dj(false);
    }

    public final void aa(int i, int i2) {
        dj(true);
    }

    public final void ab(int i, int i2) {
        dj(false);
    }

    public final void fS() {
        dj(false);
    }

    private void dj(boolean z) {
        this.jPj.s(new 1(this, z));
    }
}
