package com.tencent.mm.plugin.bottle.ui;

class ThrowBottleUI$7 implements Runnable {
    final /* synthetic */ ThrowBottleUI kEz;

    ThrowBottleUI$7(ThrowBottleUI throwBottleUI) {
        this.kEz = throwBottleUI;
    }

    public final void run() {
        ThrowBottleUI.y(this.kEz).stopTone();
    }
}
