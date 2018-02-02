package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MultiSelectContactView$6 implements AnimationListener {
    final /* synthetic */ MultiSelectContactView vkE;
    final /* synthetic */ View zS;

    MultiSelectContactView$6(MultiSelectContactView multiSelectContactView, View view) {
        this.vkE = multiSelectContactView;
        this.zS = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zS.post(new 1(this));
    }
}
