package com.tencent.mm.ui.widget;

import com.tencent.mm.ui.widget.DragSortListView.m;

class DragSortListView$j extends m {
    private float zsL;
    private float zsM;
    final /* synthetic */ DragSortListView zsq;

    public final void onStart() {
        this.zsL = (float) DragSortListView.c(this.zsq);
        this.zsM = (float) DragSortListView.d(this.zsq);
    }

    public final void aH(float f) {
        if (DragSortListView.b(this.zsq) != 4) {
            this.Mu = true;
            return;
        }
        DragSortListView.a(this.zsq, (int) ((this.zsM * f) + ((1.0f - f) * this.zsL)));
        DragSortListView.e(this.zsq).y = DragSortListView.f(this.zsq) - DragSortListView.c(this.zsq);
        DragSortListView.g(this.zsq);
    }
}
