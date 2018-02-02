package com.tencent.mm.view.footer;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$2 implements AnimationListener {
    final /* synthetic */ a zFp;

    public a$2(a aVar) {
        this.zFp = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zFp.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
