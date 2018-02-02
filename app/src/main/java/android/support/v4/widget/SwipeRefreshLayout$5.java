package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$5 extends Animation {
    final /* synthetic */ SwipeRefreshLayout EN;

    SwipeRefreshLayout$5(SwipeRefreshLayout swipeRefreshLayout) {
        this.EN = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        int j;
        if (SwipeRefreshLayout.i(this.EN)) {
            j = (int) SwipeRefreshLayout.j(this.EN);
        } else {
            j = (int) (SwipeRefreshLayout.j(this.EN) - ((float) Math.abs(this.EN.Ez)));
        }
        SwipeRefreshLayout.b(this.EN, (((int) (((float) (j - this.EN.Ex)) * f)) + this.EN.Ex) - SwipeRefreshLayout.e(this.EN).getTop());
        SwipeRefreshLayout.b(this.EN).y(1.0f - f);
    }
}
