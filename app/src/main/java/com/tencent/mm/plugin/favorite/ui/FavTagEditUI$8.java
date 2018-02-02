package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.ui.base.MMTagPanel$a;

class FavTagEditUI$8 implements MMTagPanel$a {
    final /* synthetic */ FavTagEditUI mtH;

    FavTagEditUI$8(FavTagEditUI favTagEditUI) {
        this.mtH = favTagEditUI;
    }

    public final void yI(String str) {
        FavTagEditUI.d(this.mtH).removeTag(str);
        FavTagEditUI.f(this.mtH).Ap(str);
        FavTagEditUI.c(this.mtH);
    }

    public final void yJ(String str) {
        FavTagEditUI.d(this.mtH).bi(str, true);
        FavTagEditUI.f(this.mtH).Ao(str);
        FavTagEditUI.c(this.mtH);
    }

    public final void yK(String str) {
    }

    public final void aDz() {
    }

    public final void yL(String str) {
    }

    public final void yM(String str) {
    }

    public final void j(boolean z, int i) {
    }
}
