package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.c;

class d$1 implements AnimatorUpdateListener {
    final /* synthetic */ f kcG;
    final /* synthetic */ f kcH;
    final /* synthetic */ int kcI;
    final /* synthetic */ d kcJ;

    d$1(d dVar, f fVar, f fVar2, int i) {
        this.kcJ = dVar;
        this.kcG = fVar;
        this.kcH = fVar2;
        this.kcI = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.kcG.equals(this.kcH)) {
            double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
            double d = this.kcG.x + (((this.kcH.x - this.kcG.x) * parseDouble) / this.kcJ.kcB[this.kcI]);
            double d2 = this.kcG.y + ((parseDouble * (this.kcH.y - this.kcG.y)) / this.kcJ.kcB[this.kcI]);
            h hVar = (h) this.kcJ.kcK;
            g gVar = this.kcJ.kcF;
            f fVar = new f(d, d2);
            d2 = 90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (fVar.y / gVar.kcN))) * 2.0d) * 3.141592653589793d)) * 2.0d);
            hVar.b(((c) g.h(c.class)).e(d2, ((fVar.x / gVar.kcN) - 0.5d) * 360.0d));
        }
    }
}
