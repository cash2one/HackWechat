package com.tencent.mm.ui.widget;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ui.widget.DragSortListView.m;

class DragSortListView$k extends m {
    private int ldc;
    private int zsG;
    private float zsN;
    private float zsO;
    private float zsP;
    private int zsQ = -1;
    private int zsR = -1;
    private int zsS;
    final /* synthetic */ DragSortListView zsq;

    public DragSortListView$k(DragSortListView dragSortListView, int i) {
        this.zsq = dragSortListView;
        super(dragSortListView, 0.5f, i);
    }

    public final void onStart() {
        int i = -1;
        this.zsQ = -1;
        this.zsR = -1;
        this.ldc = DragSortListView.m(this.zsq);
        this.zsS = DragSortListView.n(this.zsq);
        this.zsG = DragSortListView.i(this.zsq);
        DragSortListView.b(this.zsq, 1);
        this.zsN = (float) DragSortListView.e(this.zsq).x;
        if (DragSortListView.o(this.zsq)) {
            float width = ((float) this.zsq.getWidth()) * 2.0f;
            if (DragSortListView.p(this.zsq) == 0.0f) {
                DragSortListView dragSortListView = this.zsq;
                if (this.zsN >= 0.0f) {
                    i = 1;
                }
                DragSortListView.a(dragSortListView, ((float) i) * width);
                return;
            }
            float f = width * 2.0f;
            if (DragSortListView.p(this.zsq) < 0.0f && DragSortListView.p(this.zsq) > (-f)) {
                DragSortListView.a(this.zsq, -f);
                return;
            } else if (DragSortListView.p(this.zsq) > 0.0f && DragSortListView.p(this.zsq) < f) {
                DragSortListView.a(this.zsq, f);
                return;
            } else {
                return;
            }
        }
        DragSortListView.q(this.zsq);
    }

    public final void aH(float f) {
        float f2 = 1.0f - f;
        int firstVisiblePosition = this.zsq.getFirstVisiblePosition();
        View childAt = this.zsq.getChildAt(this.ldc - firstVisiblePosition);
        if (DragSortListView.o(this.zsq)) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
            if (uptimeMillis != 0.0f) {
                float p = DragSortListView.p(this.zsq) * uptimeMillis;
                int width = this.zsq.getWidth();
                DragSortListView.a(this.zsq, ((((float) (DragSortListView.p(this.zsq) > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + DragSortListView.p(this.zsq));
                this.zsN += p;
                DragSortListView.e(this.zsq).x = (int) this.zsN;
                if (this.zsN < ((float) width) && this.zsN > ((float) (-width))) {
                    this.mStartTime = SystemClock.uptimeMillis();
                    DragSortListView.g(this.zsq);
                    return;
                }
            }
            return;
        }
        if (childAt != null) {
            if (this.zsQ == -1) {
                this.zsQ = DragSortListView.b(this.zsq, this.ldc, childAt);
                this.zsO = (float) (childAt.getHeight() - this.zsQ);
            }
            int max = Math.max((int) (this.zsO * f2), 1);
            LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = max + this.zsQ;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.zsS != this.ldc) {
            View childAt2 = this.zsq.getChildAt(this.zsS - firstVisiblePosition);
            if (childAt2 != null) {
                if (this.zsR == -1) {
                    this.zsR = DragSortListView.b(this.zsq, this.zsS, childAt2);
                    this.zsP = (float) (childAt2.getHeight() - this.zsR);
                }
                int max2 = Math.max((int) (this.zsP * f2), 1);
                LayoutParams layoutParams2 = childAt2.getLayoutParams();
                layoutParams2.height = max2 + this.zsR;
                childAt2.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void onStop() {
        DragSortListView.r(this.zsq);
    }
}
