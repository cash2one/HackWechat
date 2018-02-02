package com.tencent.mm.plugin.card.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardBaseUI kIn;

    CardBaseUI$1(CardBaseUI cardBaseUI) {
        this.kIn = cardBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kIn.finish();
        return true;
    }
}
