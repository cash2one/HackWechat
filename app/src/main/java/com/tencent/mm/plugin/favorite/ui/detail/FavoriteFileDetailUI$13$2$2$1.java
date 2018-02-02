package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI.13.2.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

class FavoriteFileDetailUI$13$2$2$1 implements Runnable {
    final /* synthetic */ r mwx;
    final /* synthetic */ 2 mwy;

    FavoriteFileDetailUI$13$2$2$1(2 2, r rVar) {
        this.mwy = 2;
        this.mwx = rVar;
    }

    public final void run() {
        FavoriteFileDetailUI.n(this.mwy.mww.mwv.mwo).moh = true;
        this.mwx.dismiss();
        x.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteFileDetailUI.b(this.mwy.mww.mwv.mwo).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.mwy.mww.mwv.mwo).field_id));
        this.mwy.mww.mwv.mwo.finish();
    }
}
