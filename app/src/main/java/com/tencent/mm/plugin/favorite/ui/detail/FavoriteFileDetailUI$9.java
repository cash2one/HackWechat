package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.favorite.a.j;

class FavoriteFileDetailUI$9 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI mwo;

    FavoriteFileDetailUI$9(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.mwo = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        String h = j.h(FavoriteFileDetailUI.a(this.mwo));
        if (4 == FavoriteFileDetailUI.c(this.mwo)) {
            FavoriteFileDetailUI.d(this.mwo);
            FavoriteFileDetailUI.e(this.mwo);
            return;
        }
        FavoriteFileDetailUI.a(this.mwo, h);
    }
}
