package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$7 extends Animation {
    final /* synthetic */ SwipeRefreshLayout EN;

    SwipeRefreshLayout$7(SwipeRefreshLayout swipeRefreshLayout) {
        this.EN = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.a(this.EN, SwipeRefreshLayout.k(this.EN) + ((-SwipeRefreshLayout.k(this.EN)) * f));
        SwipeRefreshLayout.b(this.EN, f);
    }
}
