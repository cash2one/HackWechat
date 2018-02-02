package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI.4.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

class FavoriteSightDetailUI$4$2$1$1 implements Runnable {
    final /* synthetic */ r mwx;
    final /* synthetic */ 1 mxi;

    FavoriteSightDetailUI$4$2$1$1(1 1, r rVar) {
        this.mxi = 1;
        this.mwx = rVar;
    }

    public final void run() {
        FavoriteSightDetailUI.l(this.mxi.mxh.mxg.mxe).moh = true;
        this.mwx.dismiss();
        x.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(FavoriteSightDetailUI.a(this.mxi.mxh.mxg.mxe).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(this.mxi.mxh.mxg.mxe).field_id)});
        this.mxi.mxh.mxg.mxe.finish();
    }
}
