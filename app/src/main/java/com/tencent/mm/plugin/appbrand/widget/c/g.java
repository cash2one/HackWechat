package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

public final class g {
    private int jWB;
    public ValueAnimator jWC;
    View view;

    public g(View view) {
        this.view = view;
    }

    public final void b(int i, final Runnable runnable) {
        if (this.view != null) {
            this.jWB = i;
            if ((this.view.getBackground() instanceof ColorDrawable) && ((ColorDrawable) this.view.getBackground()).getColor() == i) {
                if (runnable != null) {
                    runnable.run();
                }
                if (this.jWC != null) {
                    this.jWC.cancel();
                    return;
                }
                return;
            }
            AnimatorListener anonymousClass1 = new AnimatorListenerAdapter(this) {
                final /* synthetic */ g jWD;

                public final void onAnimationCancel(Animator animator) {
                    this.jWD.jWC = null;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.jWD.jWC = null;
                }
            };
            if (this.jWC != null && this.jWC.isStarted() && this.jWC.isRunning() && this.jWB == i) {
                this.jWC.addListener(anonymousClass1);
                return;
            }
            if (this.jWC != null) {
                this.jWC.cancel();
            }
            int color = this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0;
            this.jWC = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(this.jWB)});
            this.jWC.addListener(anonymousClass1);
            this.jWC.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ g jWD;

                {
                    this.jWD = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (this.jWD.view != null) {
                        this.jWD.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.jWC.start();
        }
    }
}
