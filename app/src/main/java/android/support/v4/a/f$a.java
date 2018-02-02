package android.support.v4.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class f$a implements AnimatorListener {
    final b oT;
    final g oU;

    public f$a(b bVar, g gVar) {
        this.oT = bVar;
        this.oU = gVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.oT.a(this.oU);
    }

    public final void onAnimationCancel(Animator animator) {
        this.oT.aM();
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
