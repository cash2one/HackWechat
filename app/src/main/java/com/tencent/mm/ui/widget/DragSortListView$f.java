package com.tencent.mm.ui.widget;

import android.view.View;
import com.tencent.mm.ui.widget.DragSortListView.m;

class DragSortListView$f extends m {
    private int zsF;
    private int zsG;
    private float zsH;
    private float zsI;
    final /* synthetic */ DragSortListView zsq;

    public DragSortListView$f(DragSortListView dragSortListView, int i) {
        this.zsq = dragSortListView;
        super(dragSortListView, 0.5f, i);
    }

    public final void onStart() {
        this.zsF = DragSortListView.h(this.zsq);
        this.zsG = DragSortListView.i(this.zsq);
        DragSortListView.b(this.zsq, 2);
        this.zsH = (float) (DragSortListView.e(this.zsq).y - cyJ());
        this.zsI = (float) (DragSortListView.e(this.zsq).x - this.zsq.getPaddingLeft());
    }

    private int cyJ() {
        int j = (DragSortListView.j(this.zsq) + this.zsq.getDividerHeight()) / 2;
        View childAt = this.zsq.getChildAt(this.zsF - this.zsq.getFirstVisiblePosition());
        if (childAt == null) {
            this.Mu = true;
            return -1;
        } else if (this.zsF == this.zsG) {
            return childAt.getTop();
        } else {
            if (this.zsF < this.zsG) {
                return childAt.getTop() - j;
            }
            return (childAt.getBottom() + j) - DragSortListView.k(this.zsq);
        }
    }

    public final void aH(float f) {
        int cyJ = cyJ();
        float paddingLeft = (float) (DragSortListView.e(this.zsq).x - this.zsq.getPaddingLeft());
        float f2 = 1.0f - f;
        if (f2 < Math.abs(((float) (DragSortListView.e(this.zsq).y - cyJ)) / this.zsH) || f2 < Math.abs(paddingLeft / this.zsI)) {
            DragSortListView.e(this.zsq).y = cyJ + ((int) (this.zsH * f2));
            DragSortListView.e(this.zsq).x = this.zsq.getPaddingLeft() + ((int) (this.zsI * f2));
            DragSortListView.g(this.zsq);
        }
    }

    public final void onStop() {
        DragSortListView.l(this.zsq);
    }
}
