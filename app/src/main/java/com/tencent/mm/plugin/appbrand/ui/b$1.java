package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

class b$1 implements Runnable {
    final /* synthetic */ b jKD;

    b$1(b bVar) {
        this.jKD = bVar;
    }

    public final void run() {
        ViewParent parent = this.jKD.getParent();
        if (parent instanceof ViewGroup) {
            ViewPropertyAnimator animate = this.jKD.animate();
            animate.setStartDelay((long) (((float) animate.getDuration()) * 0.8f));
            animate.setDuration((long) (((float) animate.getDuration()) * 1.0f));
            animate.setListener(new 1(this, parent));
            animate.alpha(0.0f).start();
        }
    }
}
