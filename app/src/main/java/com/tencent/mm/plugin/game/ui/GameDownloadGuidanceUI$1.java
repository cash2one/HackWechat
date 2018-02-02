package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameDownloadGuidanceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameDownloadGuidanceUI npI;

    GameDownloadGuidanceUI$1(GameDownloadGuidanceUI gameDownloadGuidanceUI) {
        this.npI = gameDownloadGuidanceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.npI.finish();
        return true;
    }
}
