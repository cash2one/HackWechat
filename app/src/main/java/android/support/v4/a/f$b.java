package android.support.v4.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

class f$b implements g {
    final Animator oV;

    public f$b(Animator animator) {
        this.oV = animator;
    }

    public final void w(View view) {
        this.oV.setTarget(view);
    }

    public final void a(b bVar) {
        this.oV.addListener(new f$a(bVar, this));
    }

    public final void setDuration(long j) {
        this.oV.setDuration(j);
    }

    public final void start() {
        this.oV.start();
    }

    public final void cancel() {
        this.oV.cancel();
    }

    public final void a(d dVar) {
        if (this.oV instanceof ValueAnimator) {
            ((ValueAnimator) this.oV).addUpdateListener(new 1(this, dVar));
        }
    }

    public final float getAnimatedFraction() {
        return ((ValueAnimator) this.oV).getAnimatedFraction();
    }
}
