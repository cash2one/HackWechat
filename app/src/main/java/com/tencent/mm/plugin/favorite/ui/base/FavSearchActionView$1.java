package com.tencent.mm.plugin.favorite.ui.base;

import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class FavSearchActionView$1 implements a {
    final /* synthetic */ FavSearchActionView mvk;

    FavSearchActionView$1(FavSearchActionView favSearchActionView) {
        this.mvk = favSearchActionView;
    }

    public final void yI(String str) {
        x.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[]{str});
        FavSearchActionView.a(this.mvk).removeTag(str);
        yK(str);
    }

    public final void yJ(String str) {
    }

    public final void yK(String str) {
        FavSearchActionView.a(this.mvk, FavSearchActionView.a(this.mvk).cpC());
        FavSearchActionView.b(this.mvk).remove(str);
        FavSearchActionView.c(this.mvk);
        if (FavSearchActionView.d(this.mvk) != null) {
            FavSearchActionView.d(this.mvk).a(FavSearchActionView.e(this.mvk), FavSearchActionView.f(this.mvk), FavSearchActionView.b(this.mvk), true);
        }
    }

    public final void yL(String str) {
        FavSearchActionView.a(this.mvk, FavSearchActionView.a(this.mvk).cpC());
        FavSearchActionView.c(this.mvk);
        if (FavSearchActionView.d(this.mvk) != null) {
            FavSearchActionView.d(this.mvk).b(FavSearchActionView.e(this.mvk), FavSearchActionView.f(this.mvk), FavSearchActionView.b(this.mvk));
        }
    }

    public final void yM(String str) {
        FavSearchActionView.a(this.mvk, str);
        FavSearchActionView.d(this.mvk).a(FavSearchActionView.e(this.mvk), FavSearchActionView.f(this.mvk), FavSearchActionView.b(this.mvk), false);
    }

    public final void aDz() {
        if (FavSearchActionView.d(this.mvk) != null) {
            FavSearchActionView.d(this.mvk).Xs();
        }
    }

    public final void Ar(String str) {
        FavSearchActionView.a(this.mvk, FavSearchActionView.a(this.mvk).cpC());
        FavSearchActionView.e(this.mvk).remove(j.W(this.mvk.getContext(), str));
        FavSearchActionView.c(this.mvk);
        if (FavSearchActionView.d(this.mvk) != null) {
            FavSearchActionView.d(this.mvk).a(FavSearchActionView.e(this.mvk), FavSearchActionView.f(this.mvk), FavSearchActionView.b(this.mvk), true);
        }
    }

    public final void As(String str) {
        x.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[]{str});
        FavSearchActionView.a(this.mvk).At(str);
        Ar(str);
    }

    public final void j(boolean z, int i) {
    }
}
