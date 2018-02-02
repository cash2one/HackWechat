package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameCategoryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameCategoryUI nmk;

    GameCategoryUI$1(GameCategoryUI gameCategoryUI) {
        this.nmk = gameCategoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nmk.finish();
        return true;
    }
}
