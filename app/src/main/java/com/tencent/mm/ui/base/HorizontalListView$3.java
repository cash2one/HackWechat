package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class HorizontalListView$3 extends SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView xYh;

    HorizontalListView$3(HorizontalListView horizontalListView) {
        this.xYh = horizontalListView;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.xYh.coL();
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.xYh.aD(f);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.xYh) {
            HorizontalListView horizontalListView = this.xYh;
            horizontalListView.xXX += (int) f;
        }
        this.xYh.requestLayout();
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Rect rect = new Rect();
        for (int i = 0; i < this.xYh.getChildCount(); i++) {
            View childAt = this.xYh.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (HorizontalListView.c(this.xYh) != null) {
                    HorizontalListView.c(this.xYh).onItemClick(this.xYh, childAt, (HorizontalListView.d(this.xYh) + 1) + i, this.xYh.FP.getItemId((HorizontalListView.d(this.xYh) + 1) + i));
                }
                if (HorizontalListView.e(this.xYh) != null) {
                    HorizontalListView.e(this.xYh).onItemSelected(this.xYh, childAt, (HorizontalListView.d(this.xYh) + 1) + i, this.xYh.FP.getItemId((HorizontalListView.d(this.xYh) + 1) + i));
                }
                return true;
            }
        }
        return true;
    }
}
