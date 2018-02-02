package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameLibraryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameLibraryUI nsw;

    GameLibraryUI$1(GameLibraryUI gameLibraryUI) {
        this.nsw = gameLibraryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameLibraryUI.a(this.nsw);
        return true;
    }
}
