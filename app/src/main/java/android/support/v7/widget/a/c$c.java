package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v4.view.z;
import android.support.v7.d.a;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.c.b;
import android.view.View;

class c$c extends b {
    c$c() {
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (z && view.getTag(a.b.Jr) == null) {
            Float valueOf = Float.valueOf(z.W(view));
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            int i2 = 0;
            while (i2 < childCount) {
                float W;
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    W = z.W(childAt);
                    if (W > f3) {
                        i2++;
                        f3 = W;
                    }
                }
                W = f3;
                i2++;
                f3 = W;
            }
            z.g(view, 1.0f + f3);
            view.setTag(a.b.Jr, valueOf);
        }
        super.a(canvas, recyclerView, view, f, f2, i, z);
    }

    public final void by(View view) {
        Object tag = view.getTag(a.b.Jr);
        if (tag != null && (tag instanceof Float)) {
            z.g(view, ((Float) tag).floatValue());
        }
        view.setTag(a.b.Jr, null);
        super.by(view);
    }
}
