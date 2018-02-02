package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior.b;
import android.support.v4.view.z;
import android.support.v4.widget.u.a;
import android.view.View;

class BottomSheetBehavior$1 extends a {
    final /* synthetic */ BottomSheetBehavior fy;

    BottomSheetBehavior$1(BottomSheetBehavior bottomSheetBehavior) {
        this.fy = bottomSheetBehavior;
    }

    public final boolean b(View view, int i) {
        if (BottomSheetBehavior.a(this.fy) == 1) {
            return false;
        }
        if (BottomSheetBehavior.b(this.fy)) {
            return false;
        }
        if (BottomSheetBehavior.a(this.fy) == 3 && BottomSheetBehavior.c(this.fy) == i) {
            View view2 = (View) BottomSheetBehavior.d(this.fy).get();
            if (view2 != null && z.h(view2, -1)) {
                return false;
            }
        }
        return BottomSheetBehavior.e(this.fy) != null && BottomSheetBehavior.e(this.fy).get() == view;
    }

    public final void a(View view, int i, int i2) {
        BottomSheetBehavior.a(this.fy, i2);
    }

    public final void t(int i) {
        if (i == 1) {
            BottomSheetBehavior.b(this.fy, 1);
        }
    }

    public final void a(View view, float f, float f2) {
        int f3;
        int i = 3;
        if (f2 < 0.0f) {
            f3 = BottomSheetBehavior.f(this.fy);
        } else if (BottomSheetBehavior.g(this.fy) && BottomSheetBehavior.a(this.fy, view, f2)) {
            f3 = BottomSheetBehavior.h(this.fy);
            i = 5;
        } else if (f2 == 0.0f) {
            int top = view.getTop();
            if (Math.abs(top - BottomSheetBehavior.f(this.fy)) < Math.abs(top - BottomSheetBehavior.i(this.fy))) {
                f3 = BottomSheetBehavior.f(this.fy);
            } else {
                f3 = BottomSheetBehavior.i(this.fy);
                i = 4;
            }
        } else {
            f3 = BottomSheetBehavior.i(this.fy);
            i = 4;
        }
        if (BottomSheetBehavior.j(this.fy).t(view.getLeft(), f3)) {
            BottomSheetBehavior.b(this.fy, 2);
            z.a(view, new b(this.fy, view, i));
            return;
        }
        BottomSheetBehavior.b(this.fy, i);
    }

    public final int c(View view, int i) {
        return n.e(i, BottomSheetBehavior.f(this.fy), BottomSheetBehavior.g(this.fy) ? BottomSheetBehavior.h(this.fy) : BottomSheetBehavior.i(this.fy));
    }

    public final int d(View view, int i) {
        return view.getLeft();
    }

    public final int M() {
        if (BottomSheetBehavior.g(this.fy)) {
            return BottomSheetBehavior.h(this.fy) - BottomSheetBehavior.f(this.fy);
        }
        return BottomSheetBehavior.i(this.fy) - BottomSheetBehavior.f(this.fy);
    }
}
