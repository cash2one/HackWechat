package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameMessageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameMessageUI ntK;

    GameMessageUI$1(GameMessageUI gameMessageUI) {
        this.ntK = gameMessageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameMessageUI.a(this.ntK);
        return true;
    }
}
