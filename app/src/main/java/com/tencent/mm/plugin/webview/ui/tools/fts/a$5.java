package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class a$5 implements AnimatorUpdateListener {
    final /* synthetic */ a tEB;

    a$5(a aVar) {
        this.tEB = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = ((this.tEB.tEt[0][0] - this.tEB.tEt[0][1]) * floatValue) + this.tEB.tEt[0][1];
        this.tEB.tEl.setX(((this.tEB.tEt[1][0] - this.tEB.tEt[1][1]) * floatValue) + this.tEB.tEt[1][1]);
        this.tEB.tEl.setY(f);
        if (this.tEB.bTX()) {
            this.tEB.tEl.setPadding((int) ((((float) (this.tEB.tEj - this.tEB.tEk)) * floatValue) + ((float) this.tEB.tEk)), 0, 0, 0);
        }
        LayoutParams layoutParams = (LayoutParams) this.tEB.tEl.getLayoutParams();
        int i = (int) (floatValue * ((float) this.tEB.tEh));
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.width = ((this.tEB.tEh - i) * 2) + ((int) this.tEB.tEt[2][0]);
        this.tEB.tEl.setLayoutParams(layoutParams);
    }
}
