package com.tencent.mm.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mm.ui.base.AnimatedExpandableListView.d;

class AnimatedExpandableListView$c extends Animation {
    private View view;
    private int xXB;
    private int xXC;
    private d xXD;

    private AnimatedExpandableListView$c(View view, int i, int i2, d dVar) {
        this.xXB = i;
        this.xXC = i2 - i;
        this.view = view;
        this.xXD = dVar;
        this.view.getLayoutParams().height = i;
        this.view.requestLayout();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            int i = this.xXB + ((int) (((float) this.xXC) * f));
            this.view.getLayoutParams().height = i;
            this.xXD.xXG = i;
            this.view.requestLayout();
            return;
        }
        i = this.xXB + this.xXC;
        this.view.getLayoutParams().height = i;
        this.xXD.xXG = i;
        this.view.requestLayout();
    }
}
