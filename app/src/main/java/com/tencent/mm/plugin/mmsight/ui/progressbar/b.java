package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;

public final class b {
    ValueAnimator jWC;
    float oDR = 0.0f;
    a oDS;
    a oDT;
    boolean oDU = false;
    public a oDV;
    PointF oDW;
    PointF oDX;
    PointF oDY;
    PointF oDZ;
    PointF oEa;
    PointF oEb;
    float oEc = 0.0f;
    float oEd = 0.0f;
    float oEe = 0.0f;
    float oEf = 0.0f;
    Path oEg;
    private Paint oEh = null;

    public b(a aVar, a aVar2, a aVar3) {
        this.oDS = aVar;
        this.oDT = aVar2;
        this.oDV = aVar3;
        this.oEd = ((float) MMSightProgressBar.lXU) * 2.0f;
        this.oEe = ((float) (-MMSightProgressBar.lXU)) * 0.5f;
        this.oEg = new Path();
        this.oEh = new Paint();
        this.oEh.setAntiAlias(true);
        this.oEh.setStyle(Style.FILL);
    }
}
