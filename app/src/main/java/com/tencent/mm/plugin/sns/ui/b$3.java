package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.sns.ui.b.b;

class b$3 implements AnimationListener {
    final /* synthetic */ b rpT;
    final /* synthetic */ b rpU;

    b$3(b bVar, b bVar2) {
        this.rpU = bVar;
        this.rpT = bVar2;
    }

    public final void onAnimationStart(Animation animation) {
        if (this.rpT != null) {
            this.rpT.onAnimationStart();
        }
        this.rpU.rpS = this.rpU.rpR;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.rpT != null) {
            this.rpT.onAnimationEnd();
        }
        this.rpU.rpS = this.rpU.rpO;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
