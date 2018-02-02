package com.tencent.mm.plugin.bottle.ui;

class SprayLayout$1 implements Runnable {
    final /* synthetic */ SprayLayout kDI;

    SprayLayout$1(SprayLayout sprayLayout) {
        this.kDI = sprayLayout;
    }

    public final void run() {
        if (SprayLayout.a(this.kDI) == 0) {
            SprayLayout.b(this.kDI);
            SprayLayout.c(this.kDI).clearAnimation();
            SprayLayout.c(this.kDI).setVisibility(8);
            SprayLayout.d(this.kDI);
        } else if (SprayLayout.a(this.kDI) == 1) {
            SprayLayout.e(this.kDI).startAnimation(this.kDI.kDy);
            SprayLayout.e(this.kDI).setVisibility(0);
            SprayLayout.f(this.kDI).setVisibility(8);
            SprayLayout.c(this.kDI).setVisibility(8);
        } else if (SprayLayout.a(this.kDI) == 2) {
            SprayLayout.e(this.kDI).startAnimation(this.kDI.kDz);
            SprayLayout.f(this.kDI).startAnimation(this.kDI.kDy);
            SprayLayout.f(this.kDI).setVisibility(0);
        } else if (SprayLayout.a(this.kDI) == 3) {
            SprayLayout.e(this.kDI).clearAnimation();
            SprayLayout.e(this.kDI).setVisibility(8);
            SprayLayout.f(this.kDI).startAnimation(this.kDI.kDz);
            SprayLayout.c(this.kDI).startAnimation(this.kDI.kDy);
            SprayLayout.c(this.kDI).setVisibility(0);
        } else if (SprayLayout.a(this.kDI) == 4) {
            SprayLayout.c(this.kDI).startAnimation(this.kDI.kDA);
            SprayLayout.f(this.kDI).clearAnimation();
            SprayLayout.f(this.kDI).setVisibility(8);
        }
        if (SprayLayout.g(this.kDI) > SprayLayout.h(this.kDI)) {
            this.kDI.stop();
            return;
        }
        SprayLayout.j(this.kDI).postDelayed(SprayLayout.i(this.kDI), 280);
        SprayLayout.a(this.kDI, SprayLayout.k(this.kDI) % 5);
    }
}
