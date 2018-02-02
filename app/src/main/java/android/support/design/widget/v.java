package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.u.e;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

final class v extends e {
    private static final Handler jr = new Handler(Looper.getMainLooper());
    private float lA;
    private final int[] lw = new int[2];
    private final float[] lx = new float[2];
    private u$e$a ly;
    private u$e$b lz;
    private int mDuration = 200;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private final Runnable mRunnable = new 1(this);
    private long mStartTime;

    v() {
    }

    static /* synthetic */ void a(v vVar) {
        if (vVar.mIsRunning) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - vVar.mStartTime)) / ((float) vVar.mDuration);
            if (vVar.mInterpolator != null) {
                uptimeMillis = vVar.mInterpolator.getInterpolation(uptimeMillis);
            }
            vVar.lA = uptimeMillis;
            if (vVar.lz != null) {
                vVar.lz.ax();
            }
            if (SystemClock.uptimeMillis() >= vVar.mStartTime + ((long) vVar.mDuration)) {
                vVar.mIsRunning = false;
                if (vVar.ly != null) {
                    vVar.ly.onAnimationEnd();
                }
            }
        }
        if (vVar.mIsRunning) {
            jr.postDelayed(vVar.mRunnable, 10);
        }
    }

    public final void start() {
        if (!this.mIsRunning) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mStartTime = SystemClock.uptimeMillis();
            this.mIsRunning = true;
            jr.postDelayed(this.mRunnable, 10);
        }
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void a(u$e$a android_support_design_widget_u_e_a) {
        this.ly = android_support_design_widget_u_e_a;
    }

    public final void a(u$e$b android_support_design_widget_u_e_b) {
        this.lz = android_support_design_widget_u_e_b;
    }

    public final void g(int i, int i2) {
        this.lw[0] = i;
        this.lw[1] = i2;
    }

    public final int az() {
        return a.a(this.lw[0], this.lw[1], this.lA);
    }

    public final void e(float f, float f2) {
        this.lx[0] = f;
        this.lx[1] = f2;
    }

    public final float aA() {
        return a.b(this.lx[0], this.lx[1], this.lA);
    }

    public final void setDuration(int i) {
        this.mDuration = i;
    }

    public final void cancel() {
        this.mIsRunning = false;
        jr.removeCallbacks(this.mRunnable);
    }

    public final float getAnimatedFraction() {
        return this.lA;
    }

    public final long getDuration() {
        return (long) this.mDuration;
    }
}
