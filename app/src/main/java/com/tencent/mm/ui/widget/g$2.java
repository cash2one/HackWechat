package com.tencent.mm.ui.widget;

import android.support.design.widget.BottomSheetBehavior$a;

class g$2 extends BottomSheetBehavior$a {
    final /* synthetic */ g ztC;

    g$2(g gVar) {
        this.ztC = gVar;
    }

    public final void u(int i) {
    }

    public final void e(float f) {
        if (g.h(this.ztC) != null && !g.i(this.ztC)) {
            if (g.j(this.ztC).canScrollVertically(-1) && g.k(this.ztC) && f != 0.0f) {
                g.h(this.ztC).setVisibility(0);
            } else {
                g.h(this.ztC).setVisibility(4);
            }
        }
    }
}
