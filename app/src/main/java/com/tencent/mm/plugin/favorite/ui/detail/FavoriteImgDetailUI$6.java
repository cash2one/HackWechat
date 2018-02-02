package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;

class FavoriteImgDetailUI$6 implements p$c {
    final /* synthetic */ FavoriteImgDetailUI mwK;
    final /* synthetic */ a mwO;

    FavoriteImgDetailUI$6(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        this.mwK = favoriteImgDetailUI;
        this.mwO = aVar;
    }

    public final void a(n nVar) {
        if (FavoriteImgDetailUI.a(this.mwK)) {
            if (FavoriteImgDetailUI.b(this.mwK).aHJ()) {
                nVar.f(2, this.mwK.mController.xIM.getString(R.l.egz));
            }
            if (FavoriteImgDetailUI.b(this.mwK).aHK()) {
                nVar.f(1, this.mwK.mController.xIM.getString(R.l.egb));
            }
            nVar.f(3, this.mwK.mController.xIM.getString(R.l.egu));
            if (!bh.ov(this.mwO.mwS)) {
                nVar.eQ(4, com.tencent.mm.plugin.scanner.a.az(this.mwO.fqb, this.mwO.mwS) ? R.l.egh : R.l.egg);
            }
        }
    }
}
