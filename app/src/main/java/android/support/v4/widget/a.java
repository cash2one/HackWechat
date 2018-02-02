package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int AY = ViewConfiguration.getTapTimeout();
    private final a AJ = new a();
    private final Interpolator AK = new AccelerateInterpolator();
    private float[] AL = new float[]{0.0f, 0.0f};
    private float[] AM = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int AN;
    private int AO;
    private float[] AP = new float[]{0.0f, 0.0f};
    private float[] AQ = new float[]{0.0f, 0.0f};
    private float[] AR = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean AS;
    private boolean AT;
    private boolean AU;
    private boolean AV;
    private boolean AW;
    private boolean AX;
    private Runnable mRunnable;
    private final View oM;

    private static class a {
        int AZ;
        int Ba;
        float Bb;
        float Bc;
        long Bd = 0;
        int Be = 0;
        int Bf = 0;
        long Bg = -1;
        float Bh;
        int Bi;
        long mStartTime = Long.MIN_VALUE;

        final float f(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.Bg < 0 || j < this.Bg) {
                return a.e(((float) (j - this.mStartTime)) / ((float) this.AZ), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.Bg;
            return (a.e(((float) j2) / ((float) this.Bi), 0.0f, 1.0f) * this.Bh) + (1.0f - this.Bh);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ a Bj;

        private b(a aVar) {
            this.Bj = aVar;
        }

        public final void run() {
            int i = 0;
            if (this.Bj.AV) {
                a d;
                if (this.Bj.AT) {
                    this.Bj.AT = false;
                    d = this.Bj.AJ;
                    d.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    d.Bg = -1;
                    d.Bd = d.mStartTime;
                    d.Bh = 0.5f;
                    d.Be = 0;
                    d.Bf = 0;
                }
                d = this.Bj.AJ;
                if (d.Bg > 0 && AnimationUtils.currentAnimationTimeMillis() > d.Bg + ((long) d.Bi)) {
                    i = 1;
                }
                if (i == 0 && this.Bj.al()) {
                    if (this.Bj.AU) {
                        this.Bj.AU = false;
                        a.i(this.Bj);
                    }
                    if (d.Bd == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float f = d.f(currentAnimationTimeMillis);
                    f = (f * 4.0f) + ((-4.0f * f) * f);
                    long j = currentAnimationTimeMillis - d.Bd;
                    d.Bd = currentAnimationTimeMillis;
                    d.Be = (int) ((((float) j) * f) * d.Bb);
                    d.Bf = (int) ((f * ((float) j)) * d.Bc);
                    this.Bj.am(d.Bf);
                    z.a(this.Bj.oM, (Runnable) this);
                    return;
                }
                this.Bj.AV = false;
            }
        }
    }

    public abstract void am(int i);

    public abstract boolean an(int i);

    static /* synthetic */ void i(a aVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        aVar.oM.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a(View view) {
        this.oM = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.AR[0] = f / 1000.0f;
        this.AR[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.AQ[0] = f2 / 1000.0f;
        this.AQ[1] = f2 / 1000.0f;
        this.AN = 1;
        this.AM[0] = Float.MAX_VALUE;
        this.AM[1] = Float.MAX_VALUE;
        this.AL[0] = 0.2f;
        this.AL[1] = 0.2f;
        this.AP[0] = 0.001f;
        this.AP[1] = 0.001f;
        this.AO = AY;
        this.AJ.AZ = 500;
        this.AJ.Ba = 500;
    }

    public final a r(boolean z) {
        if (this.AW && !z) {
            cl();
        }
        this.AW = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.AW) {
            return false;
        }
        switch (o.d(motionEvent)) {
            case 0:
                this.AU = true;
                this.AS = false;
                break;
            case 1:
            case 3:
                cl();
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.oM.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.oM.getHeight());
        a aVar = this.AJ;
        aVar.Bb = a;
        aVar.Bc = a2;
        if (!this.AV && al()) {
            if (this.mRunnable == null) {
                this.mRunnable = new b();
            }
            this.AV = true;
            this.AT = true;
            if (this.AS || this.AO <= 0) {
                this.mRunnable.run();
            } else {
                z.a(this.oM, this.mRunnable, (long) this.AO);
            }
            this.AS = true;
        }
        if (this.AX && this.AV) {
            return true;
        }
        return false;
    }

    private boolean al() {
        a aVar = this.AJ;
        int abs = (int) (aVar.Bc / Math.abs(aVar.Bc));
        int abs2 = (int) (aVar.Bb / Math.abs(aVar.Bb));
        if (abs != 0 && an(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    private void cl() {
        if (this.AT) {
            this.AV = false;
            return;
        }
        a aVar = this.AJ;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i = (int) (currentAnimationTimeMillis - aVar.mStartTime);
        int i2 = aVar.Ba;
        if (i <= i2) {
            i2 = i < 0 ? 0 : i;
        }
        aVar.Bi = i2;
        aVar.Bh = aVar.f(currentAnimationTimeMillis);
        aVar.Bg = currentAnimationTimeMillis;
    }

    private float a(int i, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float e = e(this.AL[i] * f2, 0.0f, this.AM[i]);
        e = g(f2 - f, e) - g(f, e);
        if (e < 0.0f) {
            e = -this.AK.getInterpolation(-e);
        } else if (e > 0.0f) {
            e = this.AK.getInterpolation(e);
        } else {
            e = 0.0f;
            if (e == 0.0f) {
                return 0.0f;
            }
            f4 = this.AP[i];
            f5 = this.AQ[i];
            f6 = this.AR[i];
            f4 *= f3;
            if (e <= 0.0f) {
                return e(e * f4, f5, f6);
            }
            return -e((-e) * f4, f5, f6);
        }
        e = e(e, -1.0f, 1.0f);
        if (e == 0.0f) {
            return 0.0f;
        }
        f4 = this.AP[i];
        f5 = this.AQ[i];
        f6 = this.AR[i];
        f4 *= f3;
        if (e <= 0.0f) {
            return -e((-e) * f4, f5, f6);
        }
        return e(e * f4, f5, f6);
    }

    private float g(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.AN) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.AV && this.AN == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static float e(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }
}
