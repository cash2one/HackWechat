package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameSettingsUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ GameSettingsUI nvX;

    GameSettingsUI$4(GameSettingsUI gameSettingsUI) {
        this.nvX = gameSettingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nvX.setResult(0);
        this.nvX.finish();
        return true;
    }
}
