package com.tencent.mm.plugin.luckymoney.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public abstract class b {
    public int alpha;
    public long hLi;
    private final Matrix oeO = new Matrix();
    private final Paint oeP = new Paint(1);
    public long oeQ;
    public float oeR;
    public float oeS;
    public float oeT;
    public float oeU;
    public Long oeV;
    public Long oeW;
    public float oeX;
    public float oeY;
    public Long oeZ;
    public Interpolator oef;
    public Rect oeg;
    public float oel;
    public float oen;
    public Float oep;
    public Float oer;
    public float oex;
    public Float oez;
    public float ofa;
    public float ofb;
    public float ofc;
    public float ofd;
    public float ofe;
    public boolean off;
    public boolean ofg;
    public VelocityTracker ofh;
    public float ofi;
    public float ofj;
    public float ofk;
    public float ofl;
    public boolean terminated;

    protected abstract void a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3);

    public abstract int getHeight();

    public abstract int getWidth();

    public final void g(Rect rect) {
        this.oeg = rect;
        this.oeV = a(this.oep, this.oeT, this.oel);
        this.oeW = a(this.oer, this.oeU, this.oen);
        this.oeZ = a(this.oez, this.oeY, this.oex);
        if (this.ofa == 0.0f) {
            this.ofa = this.hLi >= 0 ? (float) this.hLi : 9.223372E18f;
            this.ofa = Math.min((float) a(this.oeR, this.oeT, this.oel, this.oeV, this.oep, rect.left - getWidth(), rect.right), this.ofa);
            this.ofa = Math.min((float) a(this.oeS, this.oeU, this.oen, this.oeW, this.oer, rect.top - getHeight(), rect.bottom), this.ofa);
        }
        this.oeP.setAlpha(this.alpha);
    }

    private static Long a(Float f, float f2, float f3) {
        if (f == null) {
            return null;
        }
        if (f3 != 0.0f) {
            long floatValue = (long) ((f.floatValue() - f2) / f3);
            if (floatValue <= 0) {
                floatValue = 0;
            }
            return Long.valueOf(floatValue);
        } else if (f.floatValue() < f2) {
            return Long.valueOf(0);
        } else {
            return null;
        }
    }

    private static long a(float f, float f2, float f3, Long l, Float f4, int i, int i2) {
        double sqrt;
        if (f3 != 0.0f) {
            if (f3 <= 0.0f) {
                i2 = i;
            }
            if (l == null || l.longValue() < 0) {
                sqrt = Math.sqrt((double) ((((2.0f * f3) * ((float) i2)) - ((2.0f * f3) * f)) + (f2 * f2)));
                double d = ((-sqrt) - ((double) f2)) / ((double) f3);
                if (d > 0.0d) {
                    return (long) d;
                }
                sqrt = (sqrt - ((double) f2)) / ((double) f3);
                if (sqrt > 0.0d) {
                    return (long) sqrt;
                }
                return Long.MAX_VALUE;
            }
            sqrt = ((((double) ((((float) i2) - f) - (((float) l.longValue()) * f2))) - (((0.5d * ((double) f3)) * ((double) l.longValue())) * ((double) l.longValue()))) + ((double) (f4.floatValue() * ((float) l.longValue())))) / ((double) f4.floatValue());
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        } else {
            if (l != null) {
                f2 = f4.floatValue();
            }
            if (f2 <= 0.0f) {
                i2 = i;
            }
            if (f2 == 0.0f) {
                return Long.MAX_VALUE;
            }
            sqrt = (double) ((((float) i2) - f) / f2);
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        }
    }

    public static float a(long j, float f, float f2, float f3, Long l, Float f4) {
        if (l == null || j < l.longValue()) {
            return ((((float) j) * f2) + f) + (((0.5f * f3) * ((float) j)) * ((float) j));
        }
        return (((((float) l.longValue()) * f2) + f) + (((0.5f * f3) * ((float) l.longValue())) * ((float) l.longValue()))) + (((float) (j - l.longValue())) * f4.floatValue());
    }

    public final void a(Canvas canvas, float f, float f2, float f3) {
        canvas.save();
        canvas.clipRect(this.oeg);
        this.oeO.reset();
        this.oeP.setAlpha(this.alpha);
        a(canvas, this.oeO, this.oeP, f, f2, f3);
        canvas.restore();
    }
}
