package com.tencent.mm.plugin.collect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.b;

class CollectMainUI$b$2 implements AnimationListener {
    final /* synthetic */ b lnt;
    final /* synthetic */ AnimationSet lnu;

    CollectMainUI$b$2(b bVar, AnimationSet animationSet) {
        this.lnt = bVar;
        this.lnu = animationSet;
    }

    public final void onAnimationEnd(Animation animation) {
        this.lnu.setStartOffset(1700);
        CollectMainUI.l(this.lnt.lnh).startAnimation(this.lnu);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
        CollectMainUI.l(this.lnt.lnh).setVisibility(0);
    }
}
