package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI.4;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class FavoriteSightDetailUI$4$1 implements c {
    final /* synthetic */ 4 mxg;

    FavoriteSightDetailUI$4$1(4 4) {
        this.mxg = 4;
    }

    public final void a(n nVar) {
        int i = (!FavoriteSightDetailUI.a(this.mxg.mxe).aHJ() || FavoriteSightDetailUI.j(this.mxg.mxe).e(FavoriteSightDetailUI.a(this.mxg.mxe))) ? 0 : 1;
        if (i != 0 && FavoriteSightDetailUI.b(this.mxg.mxe).wdR == 0) {
            nVar.f(0, this.mxg.mxe.getString(R.l.egz));
        }
        nVar.f(3, this.mxg.mxe.getString(R.l.eeY));
        nVar.f(2, this.mxg.mxe.mController.xIM.getString(R.l.dEw));
    }
}
