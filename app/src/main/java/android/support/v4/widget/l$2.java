package android.support.v4.widget;

import android.support.v4.widget.l.a;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class l$2 implements AnimationListener {
    final /* synthetic */ a CL;
    final /* synthetic */ l CM;

    l$2(l lVar, a aVar) {
        this.CM = lVar;
        this.CL = aVar;
    }

    public final void onAnimationStart(Animation animation) {
        l.a(this.CM, 0.0f);
    }

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
        this.CL.cy();
        a aVar = this.CL;
        aVar.aq(aVar.cx());
        this.CL.A(this.CL.CQ);
        if (this.CM.CK) {
            this.CM.CK = false;
            animation.setDuration(1332);
            this.CL.u(false);
            return;
        }
        l.a(this.CM, (l.a(this.CM) + 1.0f) % 5.0f);
    }
}
