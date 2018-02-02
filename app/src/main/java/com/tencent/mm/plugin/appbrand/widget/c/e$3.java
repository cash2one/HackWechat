package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class e$3 extends AnimatorListenerAdapter {
    final /* synthetic */ h irk;
    final /* synthetic */ View jWA;
    final /* synthetic */ e jWz;

    e$3(e eVar, View view, h hVar) {
        this.jWz = eVar;
        this.jWA = view;
        this.irk = hVar;
    }

    public final void onAnimationCancel(Animator animator) {
        onAnimationEnd(animator);
    }

    public final void onAnimationEnd(Animator animator) {
        this.jWA.setVisibility(8);
        this.jWz.removeView(this.jWA);
        e.b(this.jWz).remove(this.irk);
        e.c(this.jWz);
    }
}
