package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardDetailPreference$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardDetailPreference kQu;

    CardDetailPreference$1(CardDetailPreference cardDetailPreference) {
        this.kQu = cardDetailPreference;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kQu.finish();
        return true;
    }
}
