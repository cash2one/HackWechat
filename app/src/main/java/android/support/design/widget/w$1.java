package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.u.e.b;

class w$1 implements AnimatorUpdateListener {
    final /* synthetic */ b lD;
    final /* synthetic */ w lE;

    w$1(w wVar, b bVar) {
        this.lE = wVar;
        this.lD = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.lD.ax();
    }
}
