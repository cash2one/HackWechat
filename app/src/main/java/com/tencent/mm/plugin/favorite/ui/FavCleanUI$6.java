package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.x;

class FavCleanUI$6 implements e {
    final /* synthetic */ FavCleanUI msh;

    FavCleanUI$6(FavCleanUI favCleanUI) {
        this.msh = favCleanUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
        if (FavCleanUI.f(this.msh) != null) {
            FavCleanUI.f(this.msh).muM = j.aIK();
        }
    }
}
