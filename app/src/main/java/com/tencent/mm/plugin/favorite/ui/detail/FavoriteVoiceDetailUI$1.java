package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteVoiceDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteVoiceDetailUI mxG;

    FavoriteVoiceDetailUI$1(FavoriteVoiceDetailUI favoriteVoiceDetailUI) {
        this.mxG = favoriteVoiceDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mxG.finish();
        return true;
    }
}
