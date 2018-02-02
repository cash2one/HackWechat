package android.support.design.widget;

import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.u.c;

class AppBarLayout$Behavior$1 implements c {
    final /* synthetic */ CoordinatorLayout eX;
    final /* synthetic */ AppBarLayout eY;
    final /* synthetic */ Behavior eZ;

    AppBarLayout$Behavior$1(Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.eZ = behavior;
        this.eX = coordinatorLayout;
        this.eY = appBarLayout;
    }

    public final void a(u uVar) {
        this.eZ.c(this.eX, this.eY, uVar.ls.az());
    }
}
