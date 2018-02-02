package android.support.design.internal;

import android.graphics.Rect;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.view.View;

class ScrimInsetsFrameLayout$1 implements t {
    final /* synthetic */ ScrimInsetsFrameLayout ez;

    ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.ez = scrimInsetsFrameLayout;
    }

    public final ap a(View view, ap apVar) {
        if (ScrimInsetsFrameLayout.a(this.ez) == null) {
            ScrimInsetsFrameLayout.a(this.ez, new Rect());
        }
        ScrimInsetsFrameLayout.a(this.ez).set(apVar.getSystemWindowInsetLeft(), apVar.getSystemWindowInsetTop(), apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
        this.ez.a(ScrimInsetsFrameLayout.a(this.ez));
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.ez;
        boolean z = ScrimInsetsFrameLayout.a(this.ez).isEmpty() || ScrimInsetsFrameLayout.b(this.ez) == null;
        scrimInsetsFrameLayout.setWillNotDraw(z);
        z.E(this.ez);
        return apVar.cb();
    }
}
