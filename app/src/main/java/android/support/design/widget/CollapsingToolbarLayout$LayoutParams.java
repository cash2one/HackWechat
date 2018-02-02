package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.i;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout$LayoutParams extends LayoutParams {
    int ha = 0;
    float hb = 0.5f;

    public CollapsingToolbarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bZ);
        this.ha = obtainStyledAttributes.getInt(i.ca, 0);
        this.hb = obtainStyledAttributes.getFloat(i.cb, 0.5f);
        obtainStyledAttributes.recycle();
    }

    public CollapsingToolbarLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public CollapsingToolbarLayout$LayoutParams(LayoutParams layoutParams) {
        super(layoutParams);
    }
}
