package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.support.v4.view.b.a;
import android.support.v4.view.b.b;
import android.view.ViewGroup;
import android.view.ViewParent;

class g$1 implements Runnable {
    final /* synthetic */ g jMY;

    g$1(g gVar) {
        this.jMY = gVar;
    }

    public final void run() {
        ViewParent parent = this.jMY.getParent();
        if (parent instanceof ViewGroup) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
            ofInt.addUpdateListener(new 1(this, parent));
            ofInt.setStartDelay((long) Math.round(((float) ofInt.getDuration()) * 0.8f));
            ofInt.setDuration((long) Math.round(((float) ofInt.getDuration()) * 0.2f));
            ofInt.setInterpolator(new a());
            ofInt.start();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.setDuration((long) Math.round(((float) ofFloat.getDuration()) * 0.8f));
            ofFloat.addUpdateListener(new 2(this));
            ofFloat.setInterpolator(new b());
            ofFloat.start();
        }
    }
}
