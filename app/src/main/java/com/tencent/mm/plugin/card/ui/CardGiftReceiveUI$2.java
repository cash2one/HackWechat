package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardGiftReceiveUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ CardGiftReceiveUI kSW;

    CardGiftReceiveUI$2(CardGiftReceiveUI cardGiftReceiveUI) {
        this.kSW = cardGiftReceiveUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kSW.finish();
        return true;
    }
}
