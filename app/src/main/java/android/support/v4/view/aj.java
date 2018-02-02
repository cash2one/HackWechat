package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class aj {

    static class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ am zR;
        final /* synthetic */ View zS;

        AnonymousClass1(am amVar, View view) {
            this.zR = amVar;
            this.zS = view;
        }

        public final void onAnimationCancel(Animator animator) {
            this.zR.ar(this.zS);
        }

        public final void onAnimationEnd(Animator animator) {
            this.zR.q(this.zS);
        }

        public final void onAnimationStart(Animator animator) {
            this.zR.p(this.zS);
        }
    }
}
