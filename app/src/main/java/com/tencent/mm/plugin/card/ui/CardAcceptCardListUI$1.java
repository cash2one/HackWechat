package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class CardAcceptCardListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardAcceptCardListUI kQf;

    CardAcceptCardListUI$1(CardAcceptCardListUI cardAcceptCardListUI) {
        this.kQf = cardAcceptCardListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
        CardAcceptCardListUI.a(this.kQf, 1);
        return true;
    }
}
