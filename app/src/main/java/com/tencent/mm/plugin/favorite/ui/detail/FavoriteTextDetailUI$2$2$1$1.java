package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.plugin.favorite.ui.detail.FavoriteTextDetailUI.2.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

class FavoriteTextDetailUI$2$2$1$1 implements Runnable {
    final /* synthetic */ r mwx;
    final /* synthetic */ 1 mxr;

    FavoriteTextDetailUI$2$2$1$1(1 1, r rVar) {
        this.mxr = 1;
        this.mwx = rVar;
    }

    public final void run() {
        FavoriteTextDetailUI.f(this.mxr.mxq.mxp.mxo).moh = true;
        this.mwx.dismiss();
        x.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[]{Long.valueOf(FavoriteTextDetailUI.e(this.mxr.mxq.mxp.mxo))});
        this.mxr.mxq.mxp.mxo.finish();
    }
}
