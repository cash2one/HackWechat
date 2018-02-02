package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$1 implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout EN;

    SwipeRefreshLayout$1(SwipeRefreshLayout swipeRefreshLayout) {
        this.EN = swipeRefreshLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (SwipeRefreshLayout.a(this.EN)) {
            SwipeRefreshLayout.b(this.EN).setAlpha(255);
            SwipeRefreshLayout.b(this.EN).start();
            if (SwipeRefreshLayout.c(this.EN) && SwipeRefreshLayout.d(this.EN) != null) {
                SwipeRefreshLayout.d(this.EN);
            }
            SwipeRefreshLayout.a(this.EN, SwipeRefreshLayout.e(this.EN).getTop());
            return;
        }
        SwipeRefreshLayout.f(this.EN);
    }
}
