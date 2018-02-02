package android.support.design.widget;

import android.support.design.widget.AppBarLayout.a;
import android.support.design.widget.CollapsingToolbarLayout.2;
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams;
import android.support.v4.view.z;
import android.view.View;
import android.view.animation.Interpolator;

class CollapsingToolbarLayout$a implements a {
    final /* synthetic */ CollapsingToolbarLayout gZ;

    private CollapsingToolbarLayout$a(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.gZ = collapsingToolbarLayout;
    }

    public final void a(AppBarLayout appBarLayout, int i) {
        int systemWindowInsetTop;
        int i2 = 255;
        int i3 = 1;
        int i4 = 0;
        CollapsingToolbarLayout.b(this.gZ, i);
        if (CollapsingToolbarLayout.a(this.gZ) != null) {
            systemWindowInsetTop = CollapsingToolbarLayout.a(this.gZ).getSystemWindowInsetTop();
        } else {
            systemWindowInsetTop = 0;
        }
        int H = appBarLayout.H();
        int childCount = this.gZ.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = this.gZ.getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            z l = CollapsingToolbarLayout.l(childAt);
            switch (layoutParams.ha) {
                case 1:
                    if ((this.gZ.getHeight() - systemWindowInsetTop) + i < childAt.getHeight()) {
                        break;
                    }
                    l.p(-i);
                    break;
                case 2:
                    l.p(Math.round(layoutParams.hb * ((float) (-i))));
                    break;
                default:
                    break;
            }
        }
        if (!(CollapsingToolbarLayout.b(this.gZ) == null && CollapsingToolbarLayout.c(this.gZ) == null)) {
            View view = this.gZ;
            boolean z = this.gZ.getHeight() + i < (z.T(this.gZ) * 2) + systemWindowInsetTop;
            if (!z.ai(view) || view.isInEditMode()) {
                i3 = 0;
            }
            if (view.gV != z) {
                if (i3 != 0) {
                    if (z) {
                        i4 = 255;
                    }
                    view.R();
                    if (view.gW == null) {
                        Interpolator interpolator;
                        view.gW = aa.ay();
                        view.gW.setDuration(600);
                        u uVar = view.gW;
                        if (i4 > view.gU) {
                            interpolator = a.eC;
                        } else {
                            interpolator = a.eD;
                        }
                        uVar.setInterpolator(interpolator);
                        view.gW.a(new 2(view));
                    } else if (view.gW.ls.isRunning()) {
                        view.gW.ls.cancel();
                    }
                    view.gW.g(view.gU, i4);
                    view.gW.ls.start();
                } else {
                    if (!z) {
                        i2 = 0;
                    }
                    view.B(i2);
                }
                view.gV = z;
            }
        }
        if (CollapsingToolbarLayout.c(this.gZ) != null && systemWindowInsetTop > 0) {
            z.E(this.gZ);
        }
        CollapsingToolbarLayout.d(this.gZ).f(((float) Math.abs(i)) / ((float) ((this.gZ.getHeight() - z.T(this.gZ)) - systemWindowInsetTop)));
        if (Math.abs(i) == H) {
            z.g(appBarLayout, appBarLayout.eJ);
        } else {
            z.g(appBarLayout, 0.0f);
        }
    }
}
