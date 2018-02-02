package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameRegionSelectUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameRegionSelectUI nuG;

    GameRegionSelectUI$1(GameRegionSelectUI gameRegionSelectUI) {
        this.nuG = gameRegionSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nuG.setResult(0);
        this.nuG.aWs();
        this.nuG.finish();
        return true;
    }
}
