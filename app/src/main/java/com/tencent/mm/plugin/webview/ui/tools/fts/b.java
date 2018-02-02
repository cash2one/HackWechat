package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

public final class b extends a {
    public b(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ b tEI;

            public final boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                this.tEI.tEk = layoutParams.leftMargin - this.tEI.oHY;
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ b tEI;

            public final boolean onPreDraw() {
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                this.tEI.tEj = (int) view6.getX();
                return true;
            }
        });
    }

    public final void AV(int i) {
        U(i, true);
    }

    public final void U(int i, boolean z) {
        if (i != this.tEu) {
            switch (6.tED[i - 1]) {
                case 1:
                    bTV();
                    return;
                case 2:
                    if (z) {
                        bTW();
                        return;
                    }
                    this.tEm.setAlpha(0.0f);
                    this.tEq.setVisibility(0);
                    this.tEo.setAlpha(1.0f);
                    this.tEo.setVisibility(8);
                    this.tEp.setAlpha(1.0f);
                    this.tEl.setPadding(this.tEk, 0, 0, 0);
                    int i2 = this.tEh;
                    LayoutParams layoutParams = (LayoutParams) this.tEl.getLayoutParams();
                    layoutParams.leftMargin = this.tEh - i2;
                    layoutParams.rightMargin = this.tEh - i2;
                    layoutParams.width = (i2 * 2) + ((int) this.tEt[2][0]);
                    this.tEl.setLayoutParams(layoutParams);
                    this.tEl.post(new 4(this));
                    return;
                default:
                    return;
            }
        }
    }

    protected final void bTV() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tEt[0][0] - ((float) this.tEi) >= 0.0f) {
            ofFloat.addUpdateListener(this.tEy);
        } else {
            ofFloat.addUpdateListener(this.tEz);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tEs, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tEm, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.tEo, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat4, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener(this) {
            final /* synthetic */ b tEI;

            {
                this.tEI = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.tEI.isAnimating = true;
                if (this.tEI.tEv != null) {
                    this.tEI.tEv.onAnimationStart();
                }
                this.tEI.tEo.setVisibility(0);
                this.tEI.tEm.setVisibility(0);
                this.tEI.tEq.setVisibility(8);
                this.tEI.tEp.setVisibility(8);
            }

            public final void onAnimationEnd(Animator animator) {
                this.tEI.isAnimating = false;
                if (this.tEI.tEv != null) {
                    this.tEI.tEv.onAnimationEnd();
                }
                this.tEI.tEn.setVisibility(0);
                this.tEI.tEl.setPadding(0, 0, 0, 0);
                this.tEI.tEp.setAlpha(1.0f);
            }

            public final void onAnimationCancel(Animator animator) {
                this.tEI.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    protected final void bTW() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.tEt[0][0] - ((float) this.tEi) >= 0.0f) {
            ofFloat.addUpdateListener(this.tEw);
        } else {
            ofFloat.addUpdateListener(this.tEx);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tEs, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.tEm, "alpha", new float[]{1.0f, 0.0f});
        this.tEo.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new 5(this));
        animatorSet.start();
    }
}
