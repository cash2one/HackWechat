package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.voiceprint.ui.a.a;

class a$7 implements AnimationListener {
    final /* synthetic */ a siD;

    a$7(a aVar) {
        this.siD = aVar;
    }

    public final void onAnimationStart(Animation animation) {
        if (this.siD != null) {
            this.siD.bFN();
        }
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.siD != null) {
            this.siD.bFO();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
