package com.tencent.mm.plugin.bottle.ui;

class ThrowBottleAnimUI$1 implements Runnable {
    final /* synthetic */ ThrowBottleAnimUI kDV;

    ThrowBottleAnimUI$1(ThrowBottleAnimUI throwBottleAnimUI) {
        this.kDV = throwBottleAnimUI;
    }

    public final void run() {
        if (ThrowBottleAnimUI.a(this.kDV) != null && !ThrowBottleAnimUI.a(this.kDV).isFinishing() && ThrowBottleAnimUI.b(this.kDV) != null && ThrowBottleAnimUI.c(this.kDV) != null) {
            ThrowBottleAnimUI.b(this.kDV).setVisibility(0);
            ThrowBottleAnimUI.a(this.kDV).kBs = false;
            ThrowBottleAnimUI.a(this.kDV).nm(-1);
            ThrowBottleAnimUI.d(this.kDV);
            ThrowBottleAnimUI.e(this.kDV);
            ThrowBottleAnimUI.f(this.kDV);
            ThrowBottleAnimUI.c(this.kDV).startAnimation(ThrowBottleAnimUI.g(this.kDV));
        }
    }
}
