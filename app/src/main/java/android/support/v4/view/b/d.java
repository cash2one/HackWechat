package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float[] AF;
    private final float AG = (1.0f / ((float) (this.AF.length - 1)));

    public d(float[] fArr) {
        this.AF = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.AF.length - 1)) * f), this.AF.length - 2);
        float f2 = (f - (((float) min) * this.AG)) / this.AG;
        return ((this.AF[min + 1] - this.AF[min]) * f2) + this.AF[min];
    }
}
