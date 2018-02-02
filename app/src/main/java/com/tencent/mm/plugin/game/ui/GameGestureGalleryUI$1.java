package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameGestureGalleryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GameGestureGalleryUI nrc;

    GameGestureGalleryUI$1(GameGestureGalleryUI gameGestureGalleryUI) {
        this.nrc = gameGestureGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nrc.finish();
        return true;
    }
}
