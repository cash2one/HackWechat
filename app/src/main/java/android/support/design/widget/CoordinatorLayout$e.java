package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CoordinatorLayout$e implements OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout hB;

    CoordinatorLayout$e(CoordinatorLayout coordinatorLayout) {
        this.hB = coordinatorLayout;
    }

    public final boolean onPreDraw() {
        this.hB.i(false);
        return true;
    }
}
