package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$4 implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout EN;

    SwipeRefreshLayout$4(SwipeRefreshLayout swipeRefreshLayout) {
        this.EN = swipeRefreshLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (!SwipeRefreshLayout.g(this.EN)) {
            SwipeRefreshLayout.h(this.EN);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
