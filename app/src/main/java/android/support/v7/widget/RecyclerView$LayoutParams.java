package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class RecyclerView$LayoutParams extends MarginLayoutParams {
    final Rect RC = new Rect();
    t Vh;
    boolean Vi = true;
    boolean Vj = false;

    public RecyclerView$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerView$LayoutParams(int i, int i2) {
        super(i, i2);
    }

    public RecyclerView$LayoutParams(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public RecyclerView$LayoutParams(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public RecyclerView$LayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        super(recyclerView$LayoutParams);
    }
}
