package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameDetailRankLikedUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameDetailRankLikedUI nos;

    GameDetailRankLikedUI$1(GameDetailRankLikedUI gameDetailRankLikedUI) {
        this.nos = gameDetailRankLikedUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nos.finish();
        return true;
    }
}
