package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.voiceprint.ui.a.a;

class a$4 implements AnimationListener {
    final /* synthetic */ a siD;

    a$4(a aVar) {
        this.siD = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.siD != null) {
            this.siD.bFO();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
