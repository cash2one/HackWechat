package com.tencent.mm.plugin.favorite.ui;

import android.content.Context;
import com.tencent.mm.plugin.favorite.ui.a.d;

class FavTagEditUI$10 extends d {
    final /* synthetic */ FavTagEditUI mtH;

    FavTagEditUI$10(FavTagEditUI favTagEditUI, Context context) {
        this.mtH = favTagEditUI;
        super(context);
    }

    protected final void zs(String str) {
        FavTagEditUI.d(this.mtH).bi(str, true);
        FavTagEditUI.f(this.mtH).Ao(str);
        FavTagEditUI.d(this.mtH).cpD();
        FavTagEditUI.d(this.mtH).cpG();
        FavTagEditUI.c(this.mtH);
    }
}
