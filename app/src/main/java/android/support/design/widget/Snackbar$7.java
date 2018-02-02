package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Snackbar$7 implements AnimationListener {
    final /* synthetic */ Snackbar jw;

    Snackbar$7(Snackbar snackbar) {
        this.jw = snackbar;
    }

    public final void onAnimationEnd(Animation animation) {
        Snackbar.f(this.jw);
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
