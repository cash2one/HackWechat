package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$1 implements AnimationListener {
    final /* synthetic */ a pmz;
    final /* synthetic */ View zS;

    a$1(a aVar, View view) {
        this.pmz = aVar;
        this.zS = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zS.startAnimation(a.a(this.pmz));
    }
}
