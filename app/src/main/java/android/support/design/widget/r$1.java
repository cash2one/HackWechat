package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class r$1 implements AnimationListener {
    final /* synthetic */ r jM;

    r$1(r rVar) {
        this.jM = rVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.jM.jK == animation) {
            this.jM.jK = null;
        }
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
