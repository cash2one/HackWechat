package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class c$15 implements AnimationListener {
    final /* synthetic */ c nXi;
    final /* synthetic */ boolean nXj;

    c$15(c cVar, boolean z) {
        this.nXi = cVar;
        this.nXj = z;
    }

    public final void onAnimationStart(Animation animation) {
        x.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", Long.valueOf(System.currentTimeMillis()));
        c.c(this.nXi, false);
        c.a(this.nXi, true);
    }

    public final void onAnimationEnd(Animation animation) {
        c.c(this.nXi, true);
        if (this.nXj) {
            this.nXi.rR(c.d(this.nXi));
            c.d(this.nXi, true);
        } else {
            this.nXi.rR(c.e(this.nXi));
            c.d(this.nXi, false);
        }
        c.s(this.nXi).clearAnimation();
        c.l(this.nXi).clearAnimation();
        c.t(this.nXi).clearAnimation();
        c.c(this.nXi).clearFocus();
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
