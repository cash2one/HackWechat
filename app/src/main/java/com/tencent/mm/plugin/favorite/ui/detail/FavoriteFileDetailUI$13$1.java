package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI.13;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class FavoriteFileDetailUI$13$1 implements c {
    final /* synthetic */ 13 mwv;

    FavoriteFileDetailUI$13$1(13 13) {
        this.mwv = 13;
    }

    public final void a(n nVar) {
        if (this.mwv.mwt) {
            FavoriteFileDetailUI.j(this.mwv.mwo);
            if (!d.c(FavoriteFileDetailUI.a(this.mwv.mwo)) && FavoriteFileDetailUI.a(this.mwv.mwo).wdR == 0) {
                if (this.mwv.iGh == 8) {
                    nVar.f(0, this.mwv.mwo.getString(R.l.egz));
                } else if (this.mwv.iGh == 15) {
                    nVar.f(0, this.mwv.mwo.getString(R.l.egz));
                    nVar.f(4, this.mwv.mwo.getString(R.l.dRS));
                } else if (this.mwv.iGh == 4) {
                    nVar.f(0, this.mwv.mwo.getString(R.l.egz));
                    nVar.f(4, this.mwv.mwo.getString(R.l.dRS));
                } else {
                    nVar.f(0, this.mwv.mwo.getString(R.l.egz));
                    if (this.mwv.mwu && FavoriteFileDetailUI.b(this.mwv.mwo).aHK()) {
                        nVar.f(1, this.mwv.mwo.getString(R.l.egb));
                    }
                }
            }
        }
        if (this.mwv.mwu) {
            nVar.f(3, this.mwv.mwo.getString(R.l.eeY));
            nVar.f(2, this.mwv.mwo.mController.xIM.getString(R.l.dEw));
        }
    }
}
