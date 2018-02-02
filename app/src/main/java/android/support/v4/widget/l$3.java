package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class l$3 implements Callback {
    final /* synthetic */ l CM;

    l$3(l lVar) {
        this.CM = lVar;
    }

    public final void invalidateDrawable(Drawable drawable) {
        this.CM.invalidateSelf();
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.CM.scheduleSelf(runnable, j);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.CM.unscheduleSelf(runnable);
    }
}
