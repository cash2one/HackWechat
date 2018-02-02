package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a$3 extends AnimatorListenerAdapter {
    final /* synthetic */ a keX;

    a$3(a aVar) {
        this.keX = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.keX.setVisibility(8);
        a.b(this.keX);
    }

    public final void onAnimationCancel(Animator animator) {
        a.b(this.keX);
    }
}
