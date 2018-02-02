package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import org.xwalk.core.Log;

public final class d extends a {
    public d(Context context, View view, View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        view2.getViewTreeObserver().addOnPreDrawListener(new 1(this, view2));
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ d tEL;

            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                this.tEL.tEj = 0;
                return true;
            }
        });
    }

    protected final void bTV() {
        Log.i("MicroMsg.FTS.SosAnimatorController", "search to init");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tEt[0][0] - ((float) this.tEi) >= 0.0f) {
            ofFloat.addUpdateListener(this.tEy);
        } else {
            ofFloat.addUpdateListener(this.tEz);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tEm, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tEo, "alpha", new float[]{0.0f, 1.0f});
        this.tEp.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener(this) {
            final /* synthetic */ d tEL;

            {
                this.tEL = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.tEL.isAnimating = true;
                if (this.tEL.tEv != null) {
                    this.tEL.tEv.onAnimationStart();
                }
                this.tEL.tEo.setVisibility(0);
                this.tEL.tEm.setVisibility(0);
                this.tEL.tEq.setVisibility(8);
            }

            public final void onAnimationEnd(Animator animator) {
                this.tEL.isAnimating = false;
                if (this.tEL.tEv != null) {
                    this.tEL.tEv.onAnimationEnd();
                }
                this.tEL.tEn.setVisibility(0);
                this.tEL.tEl.setPadding(0, 0, 0, 0);
                this.tEL.tEp.setAlpha(1.0f);
                this.tEL.tEp.setVisibility(8);
            }

            public final void onAnimationCancel(Animator animator) {
                this.tEL.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    protected final void bTW() {
        Log.i("MicroMsg.FTS.SosAnimatorController", "init to search");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tEt[0][0] - ((float) this.tEi) >= 0.0f) {
            ofFloat.addUpdateListener(this.tEw);
        } else {
            ofFloat.addUpdateListener(this.tEx);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tEm, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tEo, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.tEp, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener(this) {
            final /* synthetic */ d tEL;

            {
                this.tEL = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.tEL.isAnimating = true;
                if (this.tEL.tEv != null) {
                    this.tEL.tEv.onAnimationStart();
                }
                this.tEL.tEn.setVisibility(8);
                this.tEL.tEp.setVisibility(0);
            }

            public final void onAnimationEnd(Animator animator) {
                this.tEL.isAnimating = false;
                if (this.tEL.tEv != null) {
                    this.tEL.tEv.onAnimationEnd();
                }
                this.tEL.tEq.setVisibility(0);
                this.tEL.tEo.setAlpha(1.0f);
                this.tEL.tEo.setVisibility(8);
            }

            public final void onAnimationCancel(Animator animator) {
                this.tEL.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
