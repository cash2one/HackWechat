package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class ViewPager$LayoutParams extends LayoutParams {
    public int gravity;
    int position;
    public boolean zB;
    boolean zC;
    int zD;
    float zz = 0.0f;

    public ViewPager$LayoutParams() {
        super(-1, -1);
    }

    public ViewPager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.bY());
        this.gravity = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
