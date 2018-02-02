package com.tencent.mm.b;

import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.d.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private int fcN = 200;
    private ValueAnimator fcO;
    c fcP;
    public float fcQ;
    public float fcR;
    public float fcS;
    public Rect fcT;
    public RectF fcU;
    Matrix fcV;
    public long fcW = 0;
    public AnimatorListener fcX;

    public a(c cVar) {
        this.fcP = cVar;
        this.fcV = new Matrix();
        this.fcU = new RectF();
    }

    public final void play() {
        x.i("MicroMsg.CropActionUpAnim", "[play]");
        if (this.fdb) {
            this.fdc = false;
            this.fdb = false;
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{1.0f, this.fcQ});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.fcR});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.fcS});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("background_alpha", new float[]{0.0f, 255.0f});
            this.fcO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.fcO.addUpdateListener(new 1(this));
            this.fcO.addListener(new 2(this));
            this.fcO.setInterpolator(new LinearInterpolator());
            this.fcO.setDuration((long) this.fcN);
            this.fcO.setStartDelay(this.fcW);
            this.fcO.start();
        }
    }

    public final void cancel() {
        x.d("MicroMsg.CropActionUpAnim", "[cancel]");
        this.fdc = false;
        this.fdb = true;
        if (this.fcO != null) {
            this.fcO.cancel();
        }
    }
}
