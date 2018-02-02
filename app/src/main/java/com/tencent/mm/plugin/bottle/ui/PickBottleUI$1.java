package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.plugin.bottle.a.h.b;

class PickBottleUI$1 implements Runnable {
    final /* synthetic */ PickBottleUI kDi;

    PickBottleUI$1(PickBottleUI pickBottleUI) {
        this.kDi = pickBottleUI;
    }

    public final void run() {
        PickBottleUI.a(this.kDi, new b());
        PickBottleUI.d(this.kDi).a(new 1(this));
    }
}
