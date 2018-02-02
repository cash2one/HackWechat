package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class l$1 extends Animation {
    final /* synthetic */ l$a CL;
    final /* synthetic */ l CM;

    l$1(l lVar, l$a android_support_v4_widget_l_a) {
        this.CM = lVar;
        this.CL = android_support_v4_widget_l_a;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        if (this.CM.CK) {
            l.a(this.CM, f, this.CL);
            return;
        }
        float b = l.b(this.CL);
        float f2 = this.CL.CV;
        float f3 = this.CL.CU;
        float f4 = this.CL.CW;
        l.b(this.CM, f, this.CL);
        if (f <= 0.5f) {
            float f5 = 0.8f - b;
            this.CL.A(f3 + (l.cw().getInterpolation(f / 0.5f) * f5));
        }
        if (f > 0.5f) {
            this.CL.B(((0.8f - b) * l.cw().getInterpolation((f - 0.5f) / 0.5f)) + f2);
        }
        this.CL.setRotation((0.25f * f) + f4);
        this.CM.setRotation((216.0f * f) + (1080.0f * (l.a(this.CM) / 5.0f)));
    }
}
