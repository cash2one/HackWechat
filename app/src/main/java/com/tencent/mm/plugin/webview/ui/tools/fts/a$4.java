package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class a$4 implements AnimatorUpdateListener {
    final /* synthetic */ a tEB;

    a$4(a aVar) {
        this.tEB = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.tEB.tEl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.tEB.tEl.setX(this.tEB.tEt[1][1]);
        this.tEB.tEl.setY(this.tEB.tEt[0][1]);
        if (this.tEB.bTX()) {
            this.tEB.tEl.setPadding(this.tEB.tEk, 0, 0, 0);
        }
        LayoutParams layoutParams = (LayoutParams) this.tEB.tEl.getLayoutParams();
        if (layoutParams.leftMargin != 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.width = ((int) this.tEB.tEt[2][0]) + (this.tEB.tEh * 2);
            this.tEB.tEl.setLayoutParams(layoutParams);
        }
    }
}
