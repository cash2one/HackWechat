package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameRankUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameRankUI nuu;

    GameRankUI$1(GameRankUI gameRankUI) {
        this.nuu = gameRankUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nuu.finish();
        return true;
    }
}
