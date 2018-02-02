package com.tencent.mm.plugin.game.ui.tab;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameRouteUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameRouteUI nwH;

    GameRouteUI$2(GameRouteUI gameRouteUI) {
        this.nwH = gameRouteUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameRouteUI.a(this.nwH);
        return true;
    }
}
