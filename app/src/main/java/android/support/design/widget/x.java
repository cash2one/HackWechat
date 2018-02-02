package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class x {
    private static final a lG;

    static {
        if (VERSION.SDK_INT >= 11) {
            lG = new c((byte) 0);
        } else {
            lG = new b((byte) 0);
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        lG.b(viewGroup, view, rect);
    }
}
