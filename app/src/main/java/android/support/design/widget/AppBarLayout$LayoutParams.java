package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.i;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public class AppBarLayout$LayoutParams extends LayoutParams {
    int fd = 1;
    Interpolator fe;

    public AppBarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bT);
        this.fd = obtainStyledAttributes.getInt(i.bU, 0);
        if (obtainStyledAttributes.hasValue(i.bV)) {
            this.fe = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i.bV, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public AppBarLayout$LayoutParams() {
        super(-1, -2);
    }

    public AppBarLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public AppBarLayout$LayoutParams(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public AppBarLayout$LayoutParams(LayoutParams layoutParams) {
        super(layoutParams);
    }
}
