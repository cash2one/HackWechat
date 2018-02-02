package com.tencent.mm.plugin.music.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.music.ui.b.a;

class b$a$3 implements AnimationListener {
    final /* synthetic */ a oNC;

    b$a$3(a aVar) {
        this.oNC = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.oNC.oNz = false;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
