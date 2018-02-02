package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardShopUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ CardShopUI kVo;

    CardShopUI$2(CardShopUI cardShopUI) {
        this.kVo = cardShopUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kVo.finish();
        return true;
    }
}
