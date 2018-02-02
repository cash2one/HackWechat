package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardConsumeCodeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardConsumeCodeUI kOh;

    CardConsumeCodeUI$1(CardConsumeCodeUI cardConsumeCodeUI) {
        this.kOh = cardConsumeCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kOh.setResult(-1);
        this.kOh.finish();
        return true;
    }
}
