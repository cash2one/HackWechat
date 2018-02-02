package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardListSelectedUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardListSelectedUI kUl;

    CardListSelectedUI$1(CardListSelectedUI cardListSelectedUI) {
        this.kUl = cardListSelectedUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kUl.setResult(0);
        CardListSelectedUI.a(this.kUl, "");
        this.kUl.finish();
        return true;
    }
}
