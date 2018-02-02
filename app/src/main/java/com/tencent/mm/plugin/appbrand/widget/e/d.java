package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b$f;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.q;
import java.util.ArrayList;
import java.util.List;

public final class d extends e {
    private b$f[] kcA;
    double[] kcB = new double[1];
    private double kcC;
    private boolean kcD;
    private AnimatorSet kcE;
    g kcF = new g();

    public d(h hVar, b bVar, long j, b$f[] com_tencent_mm_plugin_appbrand_compat_a_b_fArr, boolean z) {
        int i;
        super(hVar, j);
        this.kcA = com_tencent_mm_plugin_appbrand_compat_a_b_fArr;
        q abv = bVar.abv();
        for (i = 0; i <= 0; i++) {
            this.kcB[0] = abv.a(com_tencent_mm_plugin_appbrand_compat_a_b_fArr[0], com_tencent_mm_plugin_appbrand_compat_a_b_fArr[1]);
            this.kcC += this.kcB[0];
        }
        List arrayList = new ArrayList();
        for (i = 0; i <= 0; i++) {
            arrayList.add(mk(0));
        }
        this.kcL.playSequentially(arrayList);
        this.kcD = z;
        if (z) {
            anE();
        }
    }

    protected final ValueAnimator mk(int i) {
        f c = this.kcF.c(this.kcA[0]);
        f c2 = this.kcF.c(this.kcA[1]);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) this.mDuration) * this.kcB[0]) / this.kcC));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues(new float[]{(float) this.kcB[0]});
        valueAnimator.addUpdateListener(new 1(this, c, c2, 0));
        return valueAnimator;
    }

    private void anE() {
        this.kcE = new AnimatorSet();
        List arrayList = new ArrayList();
        int i = 1;
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (i < this.kcA.length) {
            float f2;
            int i4;
            int i5;
            if (this.kcA[i2].equals(this.kcA[i])) {
                f2 = f;
                i4 = i2;
                i5 = i3;
            } else {
                long j;
                long j2;
                f c = this.kcF.c(this.kcA[i3]);
                f c2 = this.kcF.c(this.kcA[i2]);
                f c3 = this.kcF.c(this.kcA[i]);
                float b = (float) b(c2.x - c.x, c.y - c2.y, c3.x - c2.x, c2.y - c3.y);
                if (b == Float.NaN) {
                    b = 0.0f;
                }
                if (arrayList.size() == 0) {
                    f = ((h) this.kcK).getRotation();
                    b = (float) b(0.0d, 1.0d, c3.x - c2.x, c2.y - c3.y);
                    j = 0;
                    j2 = 0;
                } else {
                    j2 = (long) (((((((double) Math.abs(b)) * 3.141592653589793d) * 2.0d) / 180.0d) * ((double) this.mDuration)) / this.kcC);
                    j = bW(i3, i2) - (j2 / 2);
                }
                f2 = f + b;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
                ofFloat.setDuration(j2);
                ofFloat.setStartDelay(j);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new 2(this));
                arrayList.add(ofFloat);
                i4 = i;
                i5 = i2;
            }
            i++;
            f = f2;
            i2 = i4;
            i3 = i5;
        }
        this.kcE.playSequentially(arrayList);
    }

    private static double b(double d, double d2, double d3, double d4) {
        double acos = (Math.acos(((d * d3) + (d2 * d4)) / (Math.sqrt((d * d) + (d2 * d2)) * Math.sqrt((d3 * d3) + (d4 * d4)))) * 180.0d) / 3.141592653589793d;
        if ((d * d4) - (d2 * d3) > 0.0d) {
            acos = -acos;
        }
        return (double) ((float) acos);
    }

    private long bW(int i, int i2) {
        double d = 0.0d;
        while (i < i2) {
            d += this.kcB[i];
            i++;
        }
        return (long) ((d * ((double) this.mDuration)) / this.kcC);
    }

    public final void anF() {
        super.anF();
        if (this.kcD && this.kcE != null) {
            this.kcE.start();
        }
    }
}
