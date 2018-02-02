package com.tencent.mm.plugin.facedetect.d;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ag;

class d$4 implements AnimationListener {
    final /* synthetic */ d mii;

    d$4(d dVar) {
        this.mii = dVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ag.h(new 1(this), 500);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
