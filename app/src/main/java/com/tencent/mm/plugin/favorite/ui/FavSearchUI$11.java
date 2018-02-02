package com.tencent.mm.plugin.favorite.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.base.FavSearchActionView;
import com.tencent.mm.plugin.report.service.g;

class FavSearchUI$11 extends c {
    final /* synthetic */ FavSearchUI mth;

    FavSearchUI$11(FavSearchUI favSearchUI, Context context) {
        this.mth = favSearchUI;
        super(context);
    }

    protected final void Am(String str) {
        FavSearchActionView a = FavSearchUI.a(this.mth);
        a.mvh.add(str);
        if (a.mtA != null) {
            a.mtA.YL("");
            a.mtA.bi(str, true);
            if (a.mvj != null) {
                a.Aq(a.mtA.cpC());
                a.mvj.a(a.mur, a.mvi, a.mvh, false);
                g.pQN.h(11126, new Object[]{Integer.valueOf(2)});
            }
        }
    }

    protected final void An(String str) {
        FavSearchActionView a = FavSearchUI.a(this.mth);
        a.mvh.remove(str);
        if (a.mtA != null) {
            if (a.mvh.isEmpty()) {
                a.mtA.YL(a.getResources().getString(R.l.dGz));
            }
            a.mtA.removeTag(str);
            if (a.mvj != null) {
                a.Aq(a.mtA.cpC());
                a.mvj.a(a.mur, a.mvi, a.mvh, true);
            }
        }
    }
}
