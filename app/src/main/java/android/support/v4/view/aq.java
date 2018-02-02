package android.support.v4.view;

import android.view.WindowInsets;

final class aq extends ap {
    final WindowInsets zU;

    aq(WindowInsets windowInsets) {
        this.zU = windowInsets;
    }

    public final int getSystemWindowInsetLeft() {
        return this.zU.getSystemWindowInsetLeft();
    }

    public final int getSystemWindowInsetTop() {
        return this.zU.getSystemWindowInsetTop();
    }

    public final int getSystemWindowInsetRight() {
        return this.zU.getSystemWindowInsetRight();
    }

    public final int getSystemWindowInsetBottom() {
        return this.zU.getSystemWindowInsetBottom();
    }

    public final boolean isConsumed() {
        return this.zU.isConsumed();
    }

    public final ap cb() {
        return new aq(this.zU.consumeSystemWindowInsets());
    }

    public final ap e(int i, int i2, int i3, int i4) {
        return new aq(this.zU.replaceSystemWindowInsets(i, i2, i3, i4));
    }
}
