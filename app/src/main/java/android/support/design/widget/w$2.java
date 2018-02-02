package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.u.e.a;

class w$2 extends AnimatorListenerAdapter {
    final /* synthetic */ w lE;
    final /* synthetic */ a lF;

    w$2(w wVar, a aVar) {
        this.lE = wVar;
        this.lF = aVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.lF.onAnimationEnd();
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
