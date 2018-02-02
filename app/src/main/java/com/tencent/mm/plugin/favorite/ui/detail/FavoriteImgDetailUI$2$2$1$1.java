package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.2.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

class FavoriteImgDetailUI$2$2$1$1 implements Runnable {
    final /* synthetic */ 1 mwN;
    final /* synthetic */ r mwx;

    FavoriteImgDetailUI$2$2$1$1(1 1, r rVar) {
        this.mwN = 1;
        this.mwx = rVar;
    }

    public final void run() {
        this.mwN.mwM.mwL.mwK.moJ.moh = true;
        this.mwx.dismiss();
        x.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", Long.valueOf(this.mwN.mwM.mwL.mwK.mwF.field_localId));
        this.mwN.mwM.mwL.mwK.finish();
    }
}
