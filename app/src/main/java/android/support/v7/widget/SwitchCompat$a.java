package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwitchCompat$a extends Animation {
    final /* synthetic */ SwitchCompat Zh;
    final float Zi;
    final float Zj;
    final float Zk;

    private SwitchCompat$a(SwitchCompat switchCompat, float f, float f2) {
        this.Zh = switchCompat;
        this.Zi = f;
        this.Zj = f2;
        this.Zk = f2 - f;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        SwitchCompat.a(this.Zh, this.Zi + (this.Zk * f));
    }
}
