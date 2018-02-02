package android.support.v4.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.a.f.b;

class f$b$1 implements AnimatorUpdateListener {
    final /* synthetic */ d oW;
    final /* synthetic */ b oX;

    f$b$1(b bVar, d dVar) {
        this.oX = bVar;
        this.oW = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.oW.b(this.oX);
    }
}
