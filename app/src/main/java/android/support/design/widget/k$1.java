package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.l.a;

class k$1 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean io;
    final /* synthetic */ a iq;
    private boolean iu;
    final /* synthetic */ k iw;

    k$1(k kVar, boolean z, a aVar) {
        this.iw = kVar;
        this.io = z;
        this.iq = aVar;
    }

    public final void onAnimationStart(Animator animator) {
        k.a(this.iw, true);
        this.iu = false;
        this.iw.iE.b(0, this.io);
    }

    public final void onAnimationCancel(Animator animator) {
        k.a(this.iw, false);
        this.iu = true;
    }

    public final void onAnimationEnd(Animator animator) {
        k.a(this.iw, false);
        if (!this.iu) {
            this.iw.iE.b(8, this.io);
        }
    }
}
