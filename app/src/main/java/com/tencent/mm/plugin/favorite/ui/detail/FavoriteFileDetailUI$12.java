package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;

class FavoriteFileDetailUI$12 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI mwo;

    FavoriteFileDetailUI$12(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.mwo = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        if (FavoriteFileDetailUI.b(this.mwo).isDownloading()) {
            j.g(FavoriteFileDetailUI.a(this.mwo));
            FavoriteFileDetailUI.h(this.mwo).setText(R.l.efJ);
        } else {
            j.q(FavoriteFileDetailUI.b(this.mwo));
            FavoriteFileDetailUI.h(this.mwo).setText(R.l.efK);
        }
        FavoriteFileDetailUI.i(this.mwo);
    }
}
