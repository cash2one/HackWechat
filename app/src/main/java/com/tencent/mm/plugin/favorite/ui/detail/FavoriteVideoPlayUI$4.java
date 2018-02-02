package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.ViewTreeObserver.OnPreDrawListener;

class FavoriteVideoPlayUI$4 implements OnPreDrawListener {
    final /* synthetic */ FavoriteVideoPlayUI mxB;

    FavoriteVideoPlayUI$4(FavoriteVideoPlayUI favoriteVideoPlayUI) {
        this.mxB = favoriteVideoPlayUI;
    }

    public final boolean onPreDraw() {
        FavoriteVideoPlayUI.e(this.mxB).getViewTreeObserver().removeOnPreDrawListener(this);
        FavoriteVideoPlayUI.g(this.mxB).a(FavoriteVideoPlayUI.e(this.mxB), FavoriteVideoPlayUI.f(this.mxB), new 1(this));
        return true;
    }
}
