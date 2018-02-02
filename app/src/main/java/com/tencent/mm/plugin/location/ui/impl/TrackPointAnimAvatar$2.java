package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TrackPointAnimAvatar$2 implements AnimationListener {
    final /* synthetic */ TrackPointAnimAvatar nYw;

    TrackPointAnimAvatar$2(TrackPointAnimAvatar trackPointAnimAvatar) {
        this.nYw = trackPointAnimAvatar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.nYw.bringToFront();
        TrackPointAnimAvatar.b(this.nYw).startAnimation(TrackPointAnimAvatar.c(this.nYw));
    }
}
