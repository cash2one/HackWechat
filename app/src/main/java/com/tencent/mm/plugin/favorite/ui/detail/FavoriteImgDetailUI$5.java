package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.protocal.c.uq;

class FavoriteImgDetailUI$5 implements OnLongClickListener {
    final /* synthetic */ FavoriteImgDetailUI mwK;

    FavoriteImgDetailUI$5(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.mwK = favoriteImgDetailUI;
    }

    public final boolean onLongClick(View view) {
        FavoriteImgDetailUI$a favoriteImgDetailUI$a = (FavoriteImgDetailUI$a) FavoriteImgDetailUI.g(this.mwK).get(((uq) view.getTag()).mvG);
        FavoriteImgDetailUI.a(this.mwK, favoriteImgDetailUI$a);
        if (!favoriteImgDetailUI$a.mwR) {
            FavoriteImgDetailUI.b(favoriteImgDetailUI$a);
        }
        return true;
    }
}
