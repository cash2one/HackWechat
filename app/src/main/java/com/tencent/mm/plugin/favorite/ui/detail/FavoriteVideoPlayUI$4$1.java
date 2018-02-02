package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVideoPlayUI.4;
import com.tencent.mm.ui.tools.g.b;

class FavoriteVideoPlayUI$4$1 implements b {
    final /* synthetic */ 4 mxD;

    FavoriteVideoPlayUI$4$1(4 4) {
        this.mxD = 4;
    }

    public final void onAnimationStart() {
        if (FavoriteVideoPlayUI.e(this.mxD.mxB) != null) {
            FavoriteVideoPlayUI.e(this.mxD.mxB).onResume();
        }
    }

    public final void onAnimationEnd() {
    }
}
