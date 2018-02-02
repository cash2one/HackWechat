package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.ui.PickBottleUI.1;

class PickBottleUI$1$1 implements a {
    final /* synthetic */ 1 kDj;

    PickBottleUI$1$1(1 1) {
        this.kDj = 1;
    }

    public final void cd(int i, int i2) {
        if (PickBottleUI.a(this.kDj.kDi) != null && PickBottleUI.b(this.kDj.kDi) != null) {
            PickBottleUI.a(this.kDj.kDi).stop();
            if (i2 == -2002) {
                PickBottleUI.a(this.kDj.kDi, null);
                PickBottleUI.c(this.kDj.kDi).nm(0);
                PickBottleUI.c(this.kDj.kDi).nl(R.l.dMC);
            }
            if (PickBottleUI.d(this.kDj.kDi) == null) {
                return;
            }
            if (i == 0 && i2 == 0 && PickBottleUI.d(this.kDj.kDi).kAF != -10001) {
                if (19990 == PickBottleUI.d(this.kDj.kDi).kAF) {
                    m.d(PickBottleUI.d(this.kDj.kDi).kAQ, PickBottleUI.d(this.kDj.kDi).iconUrl, R.g.bEk);
                }
                PickBottleUI.b(this.kDj.kDi).kCR = PickBottleUI.d(this.kDj.kDi).kAK;
                PickBottleUI.b(this.kDj.kDi).kAQ = PickBottleUI.d(this.kDj.kDi).kAQ;
                PickBottleUI.b(this.kDj.kDi).iconUrl = PickBottleUI.d(this.kDj.kDi).iconUrl;
                PickBottleUI.b(this.kDj.kDi).density = PickBottleUI.g(this.kDj.kDi);
                PickBottleUI.b(this.kDj.kDi).show(PickBottleUI.d(this.kDj.kDi).kAF);
                PickBottleUI.h(this.kDj.kDi).setVisibility(0);
                PickBottleUI.a(this.kDj.kDi, null);
                return;
            }
            PickBottleUI.b(this.kDj.kDi).kCR = null;
            PickBottleUI.b(this.kDj.kDi).show(-10001);
            PickBottleUI.f(this.kDj.kDi).postDelayed(PickBottleUI.e(this.kDj.kDi), 2000);
        }
    }
}
