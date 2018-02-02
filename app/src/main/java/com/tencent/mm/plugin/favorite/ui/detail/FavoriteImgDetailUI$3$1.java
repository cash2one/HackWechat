package com.tencent.mm.plugin.favorite.ui.detail;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.3;

class FavoriteImgDetailUI$3$1 implements Runnable {
    final /* synthetic */ Bitmap mwP;
    final /* synthetic */ 3 mwQ;

    FavoriteImgDetailUI$3$1(3 3, Bitmap bitmap) {
        this.mwQ = 3;
        this.mwP = bitmap;
    }

    public final void run() {
        FavoriteImgDetailUI.a(this.mwQ.mwK, this.mwQ.mwO, this.mwP);
    }

    public final String toString() {
        return super.toString() + "|renderView";
    }
}
