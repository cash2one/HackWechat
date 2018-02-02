package com.tencent.mm.plugin.appbrand.widget;

import android.animation.ObjectAnimator;

class c$4 implements Runnable {
    final /* synthetic */ c jUG;
    final /* synthetic */ ObjectAnimator jUH;

    public c$4(c cVar, ObjectAnimator objectAnimator) {
        this.jUG = cVar;
        this.jUH = objectAnimator;
    }

    public final void run() {
        this.jUG.setVisibility(0);
        c.a(this.jUG, this.jUH);
    }
}
