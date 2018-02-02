package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a$2 extends AnimatorListenerAdapter {
    final /* synthetic */ a keX;

    a$2(a aVar) {
        this.keX = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        a.a(this.keX);
    }

    public final void onAnimationCancel(Animator animator) {
        a.a(this.keX);
    }
}
