package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.l.a;

class k$2 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean io;
    final /* synthetic */ a iq;
    final /* synthetic */ k iw;

    k$2(k kVar, boolean z, a aVar) {
        this.iw = kVar;
        this.io = z;
        this.iq = aVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.iw.iE.b(0, this.io);
    }

    public final void onAnimationEnd(Animator animator) {
    }
}
