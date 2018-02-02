package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;

class FavBaseUI$2 implements a {
    final /* synthetic */ FavBaseUI mrW;
    long mrX = 0;

    FavBaseUI$2(FavBaseUI favBaseUI) {
        this.mrW = favBaseUI;
    }

    public final void a(String str, l lVar) {
        this.mrW.mrL.removeCallbacks(FavBaseUI.h(this.mrW));
        if (bh.bA(this.mrX) > 200) {
            this.mrX = bh.Wq();
            this.mrW.mrL.post(FavBaseUI.h(this.mrW));
            return;
        }
        this.mrW.mrL.postDelayed(FavBaseUI.h(this.mrW), 200);
    }
}
