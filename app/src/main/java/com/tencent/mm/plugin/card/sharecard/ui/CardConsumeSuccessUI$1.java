package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardConsumeSuccessUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardConsumeSuccessUI kOz;

    CardConsumeSuccessUI$1(CardConsumeSuccessUI cardConsumeSuccessUI) {
        this.kOz = cardConsumeSuccessUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kOz.finish();
        CardConsumeSuccessUI.avd();
        return true;
    }
}
