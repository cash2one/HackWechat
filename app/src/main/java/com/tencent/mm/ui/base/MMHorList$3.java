package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class MMHorList$3 extends SimpleOnGestureListener {
    final /* synthetic */ MMHorList ybQ;

    MMHorList$3(MMHorList mMHorList) {
        this.ybQ = mMHorList;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.ybQ.coL();
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.ybQ.aD(f);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        MMHorList.a(this.ybQ, MMHorList.c(this.ybQ) + ((int) f));
        this.ybQ.requestLayout();
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Rect rect = new Rect();
        for (int i = 0; i < this.ybQ.getChildCount(); i++) {
            View childAt = this.ybQ.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (MMHorList.d(this.ybQ) != null) {
                    MMHorList.d(this.ybQ).onItemClick(this.ybQ, childAt, (MMHorList.e(this.ybQ) + 1) + i, MMHorList.f(this.ybQ).getItemId((MMHorList.e(this.ybQ) + 1) + i));
                }
                if (MMHorList.g(this.ybQ) != null) {
                    MMHorList.g(this.ybQ).onItemSelected(this.ybQ, childAt, (MMHorList.e(this.ybQ) + 1) + i, MMHorList.f(this.ybQ).getItemId((MMHorList.e(this.ybQ) + 1) + i));
                }
                return true;
            }
        }
        return true;
    }
}
