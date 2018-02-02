package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ag;

class b$5 implements AnimationListener {
    final /* synthetic */ b qNU;

    b$5(b bVar) {
        this.qNU = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.qNU.qNS = true;
    }

    public final void onAnimationEnd(Animation animation) {
        ag.y(new 1(this));
        this.qNU.qNS = false;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
