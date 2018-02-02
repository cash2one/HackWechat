package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class a$6 implements AnimatorUpdateListener {
    final /* synthetic */ a tEB;

    a$6(a aVar) {
        this.tEB = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (((double) Math.abs(floatValue - 1.0f)) <= 0.001d) {
            this.tEB.tEl.setX(this.tEB.tEt[1][0]);
            this.tEB.tEl.setY(this.tEB.tEt[0][0]);
            if (this.tEB.bTX()) {
                this.tEB.tEl.setPadding(0, 0, 0, 0);
            }
            LayoutParams layoutParams = (LayoutParams) this.tEB.tEl.getLayoutParams();
            layoutParams.leftMargin = this.tEB.tEh;
            layoutParams.rightMargin = this.tEB.tEh;
            layoutParams.width = (int) this.tEB.tEt[2][0];
            this.tEB.tEl.setLayoutParams(layoutParams);
            this.tEB.tEl.setAlpha(1.0f);
            return;
        }
        this.tEB.tEl.setAlpha(1.0f - floatValue);
    }
}
