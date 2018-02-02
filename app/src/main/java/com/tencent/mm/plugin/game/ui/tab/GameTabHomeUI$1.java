package com.tencent.mm.plugin.game.ui.tab;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameTabHomeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameTabHomeUI nwP;

    GameTabHomeUI$1(GameTabHomeUI gameTabHomeUI) {
        this.nwP = gameTabHomeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameTabHomeUI.a(this.nwP);
        return true;
    }
}
