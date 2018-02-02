package com.tencent.mm.plugin.sns.f;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b$4 implements AnimationListener {
    final /* synthetic */ b qZH;

    b$4(b bVar) {
        this.qZH = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.qZH.qZt = true;
    }

    public final void onAnimationEnd(Animation animation) {
        this.qZH.qZt = false;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
