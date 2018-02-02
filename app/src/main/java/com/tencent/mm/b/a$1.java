package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.t.a;

class a$1 implements AnimatorUpdateListener {
    Matrix fcY = new Matrix(this.fda.fcP.uR());
    Rect fcZ = new Rect(this.fda.fcT);
    final /* synthetic */ a fda;

    a$1(a aVar) {
        this.fda = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
        float floatValue3 = ((Float) valueAnimator.getAnimatedValue("scale")).floatValue();
        float floatValue4 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
        this.fda.fcV.reset();
        this.fda.fcV.postTranslate(floatValue2, floatValue);
        RectF rectF = new RectF(this.fcZ);
        this.fda.fcV.mapRect(rectF);
        rectF.round(this.fda.fcT);
        this.fda.fcV.postScale(floatValue3, floatValue3, (float) this.fda.fcT.centerX(), (float) this.fda.fcT.centerY());
        Matrix matrix = new Matrix(this.fcY);
        matrix.postConcat(this.fda.fcV);
        this.fda.fcP.uR().set(matrix);
        a aVar = this.fda.fcP.fit;
        a.gm((int) floatValue4);
        RectF rectF2 = new RectF(this.fcZ);
        this.fda.fcV.mapRect(rectF2);
        rectF2.round(this.fda.fcT);
        this.fda.fcP.uS();
    }
}
