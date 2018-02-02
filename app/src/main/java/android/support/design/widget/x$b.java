package android.support.design.widget;

import android.graphics.Rect;
import android.support.design.widget.x.a;
import android.view.View;
import android.view.ViewGroup;

class x$b implements a {
    private x$b() {
    }

    public final void b(ViewGroup viewGroup, View view, Rect rect) {
        viewGroup.offsetDescendantRectToMyCoords(view, rect);
        rect.offset(view.getScrollX(), view.getScrollY());
    }
}
