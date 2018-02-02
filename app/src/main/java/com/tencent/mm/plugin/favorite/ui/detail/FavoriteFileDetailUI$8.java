package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.favorite.a.h;
import com.tencent.mm.plugin.favorite.a.h.a;

class FavoriteFileDetailUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteFileDetailUI mwo;

    FavoriteFileDetailUI$8(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.mwo = favoriteFileDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(a.mpT, FavoriteFileDetailUI.b(this.mwo));
        this.mwo.finish();
        return true;
    }
}
