package com.tencent.mm.plugin.webview.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class b$1 implements AnimatorUpdateListener {
    final /* synthetic */ LayoutParams tlB;
    final /* synthetic */ View tlC;
    final /* synthetic */ LayoutParams tlD;
    final /* synthetic */ View tlE;
    final /* synthetic */ b tlF;

    b$1(b bVar, LayoutParams layoutParams, View view, LayoutParams layoutParams2, View view2) {
        this.tlF = bVar;
        this.tlB = layoutParams;
        this.tlC = view;
        this.tlD = layoutParams2;
        this.tlE = view2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.tlB.height = intValue;
        this.tlC.setLayoutParams(this.tlB);
        this.tlD.height = intValue;
        this.tlE.setLayoutParams(this.tlD);
    }
}
