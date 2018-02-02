package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.base.AnimatedExpandableListView.a;
import com.tencent.mm.ui.base.AnimatedExpandableListView.b;

class AnimatedExpandableListView$a$1 implements AnimationListener {
    final /* synthetic */ int rDg;
    final /* synthetic */ b xXv;
    final /* synthetic */ a xXw;

    AnimatedExpandableListView$a$1(a aVar, int i, b bVar) {
        this.xXw = aVar;
        this.rDg = i;
        this.xXv = bVar;
    }

    public final void onAnimationEnd(Animation animation) {
        a.b(this.xXw, this.rDg);
        this.xXw.notifyDataSetChanged();
        this.xXv.setTag(Integer.valueOf(0));
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
