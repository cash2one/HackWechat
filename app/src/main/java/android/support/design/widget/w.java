package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.u.e;
import android.view.animation.Interpolator;

final class w extends e {
    final ValueAnimator lC = new ValueAnimator();

    w() {
    }

    public final void start() {
        this.lC.start();
    }

    public final boolean isRunning() {
        return this.lC.isRunning();
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.lC.setInterpolator(interpolator);
    }

    public final void a(u$e$b android_support_design_widget_u_e_b) {
        this.lC.addUpdateListener(new 1(this, android_support_design_widget_u_e_b));
    }

    public final void a(u$e$a android_support_design_widget_u_e_a) {
        this.lC.addListener(new 2(this, android_support_design_widget_u_e_a));
    }

    public final void g(int i, int i2) {
        this.lC.setIntValues(new int[]{i, i2});
    }

    public final int az() {
        return ((Integer) this.lC.getAnimatedValue()).intValue();
    }

    public final void e(float f, float f2) {
        this.lC.setFloatValues(new float[]{f, f2});
    }

    public final float aA() {
        return ((Float) this.lC.getAnimatedValue()).floatValue();
    }

    public final void setDuration(int i) {
        this.lC.setDuration((long) i);
    }

    public final void cancel() {
        this.lC.cancel();
    }

    public final float getAnimatedFraction() {
        return this.lC.getAnimatedFraction();
    }

    public final long getDuration() {
        return this.lC.getDuration();
    }
}
