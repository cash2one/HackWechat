package com.tencent.mm.plugin.favorite.ui.detail;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteImgDetailUI$3 implements Runnable {
    final /* synthetic */ FavoriteImgDetailUI mwK;
    final /* synthetic */ a mwO;

    FavoriteImgDetailUI$3(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        this.mwK = favoriteImgDetailUI;
        this.mwO = aVar;
    }

    public final void run() {
        Bitmap a = h.a(this.mwO.fve, FavoriteImgDetailUI.b(this.mwK), false);
        if (a == null) {
            x.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
            a = FavoriteImgDetailUI.a(this.mwK, this.mwO.fve);
        }
        ag.y(new 1(this, a));
    }
}
