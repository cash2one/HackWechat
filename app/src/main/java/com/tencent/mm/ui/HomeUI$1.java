package com.tencent.mm.ui;

import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.vending.g.g;

class HomeUI$1 implements a {
    final /* synthetic */ HomeUI xGv;

    HomeUI$1(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void wy() {
        if (com.tencent.mm.blink.a.wl()) {
            com.tencent.mm.blink.a.fh(6);
            com.tencent.mm.blink.a.wm();
            com.tencent.mm.blink.a.ec("First Screen");
            g.czW().gs(500).c(new 1(this));
        }
        b.wo().ws();
    }
}
