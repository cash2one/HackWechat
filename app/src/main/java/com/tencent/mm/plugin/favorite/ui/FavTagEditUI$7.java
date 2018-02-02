package com.tencent.mm.plugin.favorite.ui;

import android.content.Context;
import com.tencent.mm.plugin.favorite.ui.a.c;

class FavTagEditUI$7 extends c {
    final /* synthetic */ FavTagEditUI mtH;

    FavTagEditUI$7(FavTagEditUI favTagEditUI, Context context) {
        this.mtH = favTagEditUI;
        super(context);
    }

    protected final void Am(String str) {
        FavTagEditUI.d(this.mtH).bi(str, true);
        if (FavTagEditUI.g(this.mtH) != null) {
            FavTagEditUI.g(this.mtH).bj(str, true);
        }
        FavTagEditUI.c(this.mtH);
    }

    protected final void An(String str) {
        FavTagEditUI.d(this.mtH).removeTag(str);
        if (FavTagEditUI.g(this.mtH) != null) {
            FavTagEditUI.g(this.mtH).bj(str, false);
        }
        FavTagEditUI.c(this.mtH);
    }
}
