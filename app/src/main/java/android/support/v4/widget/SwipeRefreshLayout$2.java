package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$2 extends Animation {
    final /* synthetic */ SwipeRefreshLayout EN;

    SwipeRefreshLayout$2(SwipeRefreshLayout swipeRefreshLayout) {
        this.EN = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.a(this.EN, 1.0f - f);
    }
}
