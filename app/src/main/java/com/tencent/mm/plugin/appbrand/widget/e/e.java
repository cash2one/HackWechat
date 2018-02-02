package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.mm.plugin.appbrand.compat.a.b.d;

public abstract class e {
    d kcK;
    AnimatorSet kcL = new AnimatorSet();
    long mDuration;

    protected abstract ValueAnimator mk(int i);

    protected e(d dVar, long j) {
        this.kcK = dVar;
        this.mDuration = j;
    }

    public void anF() {
        this.kcL.start();
    }

    public final void a(AnimatorListener animatorListener) {
        this.kcL.addListener(animatorListener);
    }
}
