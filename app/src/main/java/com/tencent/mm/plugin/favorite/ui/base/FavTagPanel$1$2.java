package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel.1;

class FavTagPanel$1$2 implements Runnable {
    final /* synthetic */ View jLA;
    final /* synthetic */ 1 mvs;

    FavTagPanel$1$2(1 1, View view) {
        this.mvs = 1;
        this.jLA = view;
    }

    public final void run() {
        FavTagPanel.a(this.mvs.mvr).As(((TextView) this.jLA).getText().toString());
    }
}
