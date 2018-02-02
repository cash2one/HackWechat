package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.z;
import android.view.View;
import java.util.List;

public class FloatingActionButton$a extends Behavior<FloatingActionButton> {
    private static final boolean ie = (VERSION.SDK_INT >= 11);
    private Rect gO;
    private u if;
    private float ig;

    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        int i3 = 0;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        List n = coordinatorLayout.n(floatingActionButton);
        int size = n.size();
        for (i2 = 0; i2 < size; i2++) {
            View view2 = (View) n.get(i2);
            if ((view2 instanceof AppBarLayout) && a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                break;
            }
        }
        coordinatorLayout.e(floatingActionButton, i);
        Rect c = FloatingActionButton.c(floatingActionButton);
        if (c != null && c.centerX() > 0 && c.centerY() > 0) {
            d dVar = (d) floatingActionButton.getLayoutParams();
            i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin ? c.right : floatingActionButton.getLeft() <= dVar.leftMargin ? -c.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - dVar.bottomMargin) {
                i3 = c.bottom;
            } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                i3 = -c.top;
            }
            floatingActionButton.offsetTopAndBottom(i3);
            floatingActionButton.offsetLeftAndRight(i2);
        }
        return true;
    }

    public final /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        if (view2 instanceof SnackbarLayout) {
            float min;
            float f = 0.0f;
            List n = coordinatorLayout.n(floatingActionButton);
            int size = n.size();
            int i = 0;
            while (i < size) {
                View view3 = (View) n.get(i);
                if (view3 instanceof SnackbarLayout) {
                    boolean z;
                    if (floatingActionButton.getVisibility() == 0 && view3.getVisibility() == 0) {
                        Rect rect = coordinatorLayout.hl;
                        coordinatorLayout.a((View) floatingActionButton, floatingActionButton.getParent() != coordinatorLayout, rect);
                        Rect rect2 = coordinatorLayout.hm;
                        coordinatorLayout.a(view3, view3.getParent() != coordinatorLayout, rect2);
                        z = rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
                    } else {
                        z = false;
                    }
                    if (z) {
                        min = Math.min(f, z.R(view3) - ((float) view3.getHeight()));
                        i++;
                        f = min;
                    }
                }
                min = f;
                i++;
                f = min;
            }
            if (this.ig != f) {
                min = z.R(floatingActionButton);
                if (this.if != null && this.if.ls.isRunning()) {
                    this.if.ls.cancel();
                }
                if (!floatingActionButton.isShown() || Math.abs(min - f) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                    z.c(floatingActionButton, f);
                } else {
                    if (this.if == null) {
                        this.if = aa.ay();
                        this.if.setInterpolator(a.eB);
                        this.if.a(new 1(this, floatingActionButton));
                    }
                    this.if.e(min, f);
                    this.if.ls.start();
                }
                this.ig = f;
            }
        } else if (view2 instanceof AppBarLayout) {
            a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ boolean e(View view) {
        return ie && (view instanceof SnackbarLayout);
    }

    private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
        int i = 0;
        if (((d) floatingActionButton.getLayoutParams()).hG != appBarLayout.getId()) {
            return false;
        }
        if (floatingActionButton.lT != 0) {
            return false;
        }
        if (this.gO == null) {
            this.gO = new Rect();
        }
        Rect rect = this.gO;
        x.a(coordinatorLayout, appBarLayout, rect);
        int i2 = rect.bottom;
        int I = appBarLayout.I();
        int T = z.T(appBarLayout);
        if (T != 0) {
            i = (T * 2) + I;
        } else {
            T = appBarLayout.getChildCount();
            if (T > 0) {
                i = (z.T(appBarLayout.getChildAt(T - 1)) * 2) + I;
            }
        }
        if (i2 <= i) {
            FloatingActionButton.a(floatingActionButton);
        } else {
            FloatingActionButton.b(floatingActionButton);
        }
        return true;
    }
}
