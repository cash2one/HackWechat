package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ad {
    private static ThreadLocal<Rect> yv;

    static class AnonymousClass1 implements OnApplyWindowInsetsListener {
        final /* synthetic */ t yw;

        AnonymousClass1(t tVar) {
            this.yw = tVar;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((aq) this.yw.a(view, new aq(windowInsets))).zU;
        }
    }

    static Rect bP() {
        if (yv == null) {
            yv = new ThreadLocal();
        }
        Rect rect = (Rect) yv.get();
        if (rect == null) {
            rect = new Rect();
            yv.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
