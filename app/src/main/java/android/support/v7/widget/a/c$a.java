package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class c$a implements b {
    c$a() {
    }

    private static void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
        canvas.save();
        canvas.translate(f, f2);
        recyclerView.drawChild(canvas, view, 0);
        canvas.restore();
    }

    public final void by(View view) {
        view.setVisibility(0);
    }

    public final void bz(View view) {
        view.setVisibility(4);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (i != 2) {
            a(canvas, recyclerView, view, f, f2);
        }
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i) {
        if (i == 2) {
            a(canvas, recyclerView, view, f, f2);
        }
    }
}
