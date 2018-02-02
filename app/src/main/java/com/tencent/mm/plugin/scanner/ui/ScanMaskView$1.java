package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ScanMaskView$1 implements AnimatorUpdateListener {
    final /* synthetic */ ScanMaskView pXg;

    ScanMaskView$1(ScanMaskView scanMaskView) {
        this.pXg = scanMaskView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ScanMaskView.a(this.pXg).left = ScanMaskView.b(this.pXg).left + ((int) (ScanMaskView.c(this.pXg) * floatValue));
        ScanMaskView.a(this.pXg).right = ScanMaskView.b(this.pXg).right + ((int) (ScanMaskView.d(this.pXg) * floatValue));
        ScanMaskView.a(this.pXg).top = ScanMaskView.b(this.pXg).top + ((int) (ScanMaskView.e(this.pXg) * floatValue));
        ScanMaskView.a(this.pXg).bottom = ((int) (floatValue * ScanMaskView.f(this.pXg))) + ScanMaskView.b(this.pXg).bottom;
        this.pXg.invalidate();
    }
}
