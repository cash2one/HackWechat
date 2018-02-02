package com.tencent.mm.ui.widget;

import android.os.SystemClock;
import android.view.View;

class DragSortListView$d implements Runnable {
    private float zsA;
    boolean zsB = false;
    final /* synthetic */ DragSortListView zsq;
    private boolean zst;
    private long zsu;
    private long zsv;
    private int zsw;
    private float zsx;
    private long zsy;
    int zsz;

    public DragSortListView$d(DragSortListView dragSortListView) {
        this.zsq = dragSortListView;
    }

    public final void GU(int i) {
        if (!this.zsB) {
            this.zst = false;
            this.zsB = true;
            this.zsy = SystemClock.uptimeMillis();
            this.zsu = this.zsy;
            this.zsz = i;
            this.zsq.post(this);
        }
    }

    public final void cyI() {
        this.zsq.removeCallbacks(this);
        this.zsB = false;
    }

    public final void run() {
        if (this.zst) {
            this.zsB = false;
            return;
        }
        View childAt;
        int firstVisiblePosition = this.zsq.getFirstVisiblePosition();
        int lastVisiblePosition = this.zsq.getLastVisiblePosition();
        int count = this.zsq.getCount();
        int paddingTop = this.zsq.getPaddingTop();
        int height = (this.zsq.getHeight() - paddingTop) - this.zsq.getPaddingBottom();
        int min = Math.min(DragSortListView.f(this.zsq), DragSortListView.s(this.zsq) + DragSortListView.d(this.zsq));
        int max = Math.max(DragSortListView.f(this.zsq), DragSortListView.s(this.zsq) - DragSortListView.d(this.zsq));
        if (this.zsz == 0) {
            childAt = this.zsq.getChildAt(0);
            if (childAt == null) {
                this.zsB = false;
                return;
            } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                this.zsB = false;
                return;
            } else {
                this.zsA = DragSortListView.v(this.zsq).aG((DragSortListView.t(this.zsq) - ((float) max)) / DragSortListView.u(this.zsq));
            }
        } else {
            View childAt2 = this.zsq.getChildAt(lastVisiblePosition - firstVisiblePosition);
            if (childAt2 == null) {
                this.zsB = false;
                return;
            } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                this.zsA = -DragSortListView.v(this.zsq).aG((((float) min) - DragSortListView.w(this.zsq)) / DragSortListView.x(this.zsq));
            } else {
                this.zsB = false;
                return;
            }
        }
        this.zsv = SystemClock.uptimeMillis();
        this.zsx = (float) (this.zsv - this.zsu);
        this.zsw = Math.round(this.zsA * this.zsx);
        if (this.zsw >= 0) {
            this.zsw = Math.min(height, this.zsw);
            lastVisiblePosition = firstVisiblePosition;
        } else {
            this.zsw = Math.max(-height, this.zsw);
        }
        childAt = this.zsq.getChildAt(lastVisiblePosition - firstVisiblePosition);
        firstVisiblePosition = childAt.getTop() + this.zsw;
        if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
            firstVisiblePosition = paddingTop;
        }
        DragSortListView.a(this.zsq, true);
        this.zsq.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
        this.zsq.layoutChildren();
        this.zsq.invalidate();
        DragSortListView.a(this.zsq, false);
        DragSortListView.c(this.zsq, lastVisiblePosition, childAt);
        this.zsu = this.zsv;
        this.zsq.post(this);
    }
}
