package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$3 extends Animation {
    final /* synthetic */ SwipeRefreshLayout EN;
    final /* synthetic */ int EO;
    final /* synthetic */ int EP;

    SwipeRefreshLayout$3(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.EN = swipeRefreshLayout;
        this.EO = i;
        this.EP = i2;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.b(this.EN).setAlpha((int) (((float) this.EO) + (((float) (this.EP - this.EO)) * f)));
    }
}
