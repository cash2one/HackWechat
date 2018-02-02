package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class FavoriteVoiceDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteVoiceDetailUI mxG;

    FavoriteVoiceDetailUI$2(FavoriteVoiceDetailUI favoriteVoiceDetailUI) {
        this.mxG = favoriteVoiceDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.mxG.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
