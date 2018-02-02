package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class al {

    static class AnonymousClass1 implements AnimatorUpdateListener {
        final /* synthetic */ View zS;
        final /* synthetic */ ao zT;

        AnonymousClass1(ao aoVar, View view) {
            this.zT = aoVar;
            this.zS = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.zT.ca();
        }
    }
}
