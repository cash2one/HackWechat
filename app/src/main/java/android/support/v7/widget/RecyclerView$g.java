package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;

public abstract class RecyclerView$g {
    public void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
    }

    public void a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        ((RecyclerView$LayoutParams) view.getLayoutParams()).Vh.gd();
        rect.set(0, 0, 0, 0);
    }
}
