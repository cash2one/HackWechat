package com.tencent.mm.view.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.view.b.a.a;

class a$a$1 implements AnimatorUpdateListener {
    float fdg = 0.0f;
    float fdh = 0.0f;
    int fdo = 0;
    float fdp = ((float) Math.pow((double) this.zEO.gr, 0.10000000149011612d));
    float zEN = 0.0f;
    final /* synthetic */ a zEO;

    a$a$1(a aVar) {
        this.zEO = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
        float floatValue3 = ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue();
        if (this.fdo < 10) {
            this.zEO.zEI.fhZ.postScale(this.fdp, this.fdp, (float) this.zEO.zEI.zEC.centerX(), (float) this.zEO.zEI.zEC.centerY());
            this.fdo++;
        }
        this.zEO.fdk += floatValue2 - this.fdh;
        this.zEO.fdl += floatValue - this.fdg;
        this.zEO.zEI.fhZ.postTranslate(this.zEO.fdk - this.zEO.zEI.cAw().centerX(), this.zEO.fdl - this.zEO.zEI.cAw().centerY());
        if (this.zEO.fN != 0.0f) {
            this.zEO.zEI.fhZ.postRotate(floatValue3 - this.zEN, this.zEO.fdk, this.zEO.fdl);
        }
        this.zEO.zEI.postInvalidate();
        this.fdg = floatValue;
        this.fdh = floatValue2;
        this.zEN = floatValue3;
    }
}
