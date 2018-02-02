package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardHomePageUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ CardHomePageUI kTC;

    CardHomePageUI$3(CardHomePageUI cardHomePageUI) {
        this.kTC = cardHomePageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (CardHomePageUI.a(this.kTC) == 1 || CardHomePageUI.a(this.kTC) == 2) {
            CardHomePageUI.b(this.kTC);
        } else {
            this.kTC.finish();
        }
        return true;
    }
}
