package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a$i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public final /* bridge */ /* synthetic */ int K() {
        return super.K();
    }

    public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        return super.a(coordinatorLayout, view, i);
    }

    public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        return super.a(coordinatorLayout, view, i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean p(int i) {
        return super.p(i);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$i.dd);
        this.iS = obtainStyledAttributes.getDimensionPixelSize(a$i.de, 0);
        obtainStyledAttributes.recycle();
    }

    public final boolean e(View view) {
        return view instanceof AppBarLayout;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Behavior behavior = ((d) view2.getLayoutParams()).hC;
        if (behavior instanceof AppBarLayout.Behavior) {
            int bottom = view2.getBottom() - view.getTop();
            z.j(view, ((AppBarLayout.Behavior.a((AppBarLayout.Behavior) behavior) + bottom) + this.iR) - o(view2));
        }
        return false;
    }

    final float f(View view) {
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int H = appBarLayout.H();
            int b = AppBarLayout.b(appBarLayout);
            Behavior behavior = ((d) appBarLayout.getLayoutParams()).hC;
            int J = behavior instanceof AppBarLayout.Behavior ? ((AppBarLayout.Behavior) behavior).J() : 0;
            if (b != 0 && H + J <= b) {
                return 0.0f;
            }
            H -= b;
            if (H != 0) {
                return (((float) J) / ((float) H)) + 1.0f;
            }
        }
        return 0.0f;
    }

    final View c(List<View> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = (View) list.get(i);
            if (view instanceof AppBarLayout) {
                return view;
            }
        }
        return null;
    }

    final int g(View view) {
        if (view instanceof AppBarLayout) {
            return ((AppBarLayout) view).H();
        }
        return super.g(view);
    }
}
