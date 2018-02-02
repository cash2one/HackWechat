package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements AnimatorUpdateListener {
    final /* synthetic */ b oEi;

    b$1(b bVar) {
        this.oEi = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.oEi.oDR = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        b bVar = this.oEi;
        float f = this.oEi.oDR;
        bVar.oEf = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.oDE + (MMSightProgressBar.lXU * 2)))) * (f / 100.0f)));
        bVar.oEc = bVar.oEd - ((f / 100.0f) * (bVar.oEd - bVar.oEe));
        bVar.oDW = new PointF((float) MMSightProgressBar.lXU, 0.0f);
        bVar.oDX = new PointF(((float) MMSightProgressBar.lXU) + (bVar.oEf / 2.0f), ((float) MMSightProgressBar.lXU) - (bVar.oEc / 2.0f));
        bVar.oDY = new PointF(((float) MMSightProgressBar.lXU) + bVar.oEf, 0.0f);
        bVar.oDZ = new PointF((float) MMSightProgressBar.lXU, (float) (MMSightProgressBar.lXU * 2));
        bVar.oEa = new PointF(((float) MMSightProgressBar.lXU) + (bVar.oEf / 2.0f), ((float) MMSightProgressBar.lXU) + (bVar.oEc / 2.0f));
        bVar.oEb = new PointF(((float) MMSightProgressBar.lXU) + bVar.oEf, ((float) MMSightProgressBar.lXU) * 2.0f);
        x.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", new Object[]{Float.valueOf(bVar.oEf), Float.valueOf(bVar.oEc)});
        x.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", new Object[]{bVar.oDW, bVar.oDX, bVar.oDY, bVar.oDZ, bVar.oEa, bVar.oEb});
        if (this.oEi.oDV != null) {
            this.oEi.oDV.bbK();
        }
    }
}
