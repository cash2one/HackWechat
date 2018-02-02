package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.view.b.a;

public final class d extends b {
    public ValueAnimator fcO;
    public a fdj;
    public float fdk;
    public float fdl;
    public boolean fdm = true;
    public boolean fdn = false;
    public float gr = 1.0f;

    class AnonymousClass1 implements AnimatorUpdateListener {
        float fdg = 0.0f;
        float fdh = 0.0f;
        int fdo = 0;
        float fdp = ((float) Math.pow((double) (this.fdr.gr / this.fdq), 0.25d));
        final /* synthetic */ float fdq;
        final /* synthetic */ d fdr;

        public AnonymousClass1(d dVar, float f) {
            this.fdr = dVar;
            this.fdq = f;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            float f2 = 0.0f;
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            if (this.fdo < 4 && this.fdr.fdm) {
                this.fdr.fdj.uR().postScale(this.fdp, this.fdp);
                this.fdo++;
            }
            RectF cAw = this.fdr.fdj.cAw();
            Rect rect = this.fdr.fdj.zEC;
            if (this.fdr.fdn) {
                if (cAw.top > ((float) rect.top)) {
                    f = ((float) rect.top) - cAw.top;
                } else {
                    f = 0.0f;
                }
                if (cAw.right < ((float) rect.right)) {
                    f2 = ((float) rect.right) - cAw.right;
                }
                if (cAw.bottom < ((float) rect.bottom)) {
                    f = ((float) rect.bottom) - cAw.bottom;
                }
                if (cAw.left > ((float) rect.left)) {
                    f2 = ((float) rect.left) - cAw.left;
                }
            } else {
                d dVar = this.fdr;
                dVar.fdk += floatValue2 - this.fdh;
                dVar = this.fdr;
                dVar.fdl += floatValue - this.fdg;
                f2 = this.fdr.fdk - cAw.centerX();
                f = this.fdr.fdl - cAw.centerY();
            }
            this.fdr.fdj.uR().postTranslate(f2, f);
            this.fdr.fdj.postInvalidate();
            this.fdg = floatValue;
            this.fdh = floatValue2;
        }
    }

    public d(a aVar) {
        this.fdj = aVar;
    }
}
