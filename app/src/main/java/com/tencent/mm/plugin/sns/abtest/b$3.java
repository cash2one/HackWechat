package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b$3 implements AnimationListener {
    final /* synthetic */ b qNU;

    b$3(b bVar) {
        this.qNU = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.qNU.qNS = true;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.qNU.qNE != null) {
            this.qNU.qNE.setVisibility(0);
        }
        this.qNU.qNS = false;
        this.qNU.qNQ = true;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
