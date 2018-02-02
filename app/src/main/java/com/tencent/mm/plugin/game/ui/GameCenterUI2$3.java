package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameCenterUI2$3 implements OnMenuItemClickListener {
    final /* synthetic */ GameCenterUI2 nnh;

    GameCenterUI2$3(GameCenterUI2 gameCenterUI2) {
        this.nnh = gameCenterUI2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameCenterUI2.e(this.nnh);
        return true;
    }
}
