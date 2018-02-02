package com.tencent.mm.ui.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;

class HorizontalListViewV2$a extends SimpleOnGestureListener {
    final /* synthetic */ HorizontalListViewV2 xYC;

    private HorizontalListViewV2$a(HorizontalListViewV2 horizontalListViewV2) {
        this.xYC = horizontalListViewV2;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.xYC.onDown(motionEvent);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.xYC.aD(f);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        HorizontalListViewV2.a(this.xYC, Boolean.valueOf(true));
        HorizontalListViewV2.a(this.xYC, a.xYE);
        HorizontalListViewV2.d(this.xYC);
        HorizontalListViewV2 horizontalListViewV2 = this.xYC;
        horizontalListViewV2.xXX += (int) f;
        HorizontalListViewV2.b(this.xYC, Math.round(f));
        this.xYC.requestLayout();
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        HorizontalListViewV2.d(this.xYC);
        OnItemClickListener onItemClickListener = this.xYC.getOnItemClickListener();
        int a = HorizontalListViewV2.a(this.xYC, (int) motionEvent.getX(), (int) motionEvent.getY());
        if (a >= 0 && !HorizontalListViewV2.f(this.xYC)) {
            View childAt = this.xYC.getChildAt(a);
            int g = HorizontalListViewV2.g(this.xYC) + a;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.xYC, childAt, g, this.xYC.FP.getItemId(g));
                return true;
            }
        }
        if (!(HorizontalListViewV2.h(this.xYC) == null || HorizontalListViewV2.f(this.xYC))) {
            HorizontalListViewV2.h(this.xYC).onClick(this.xYC);
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        HorizontalListViewV2.d(this.xYC);
        int a = HorizontalListViewV2.a(this.xYC, (int) motionEvent.getX(), (int) motionEvent.getY());
        if (a >= 0 && !HorizontalListViewV2.f(this.xYC)) {
            View childAt = this.xYC.getChildAt(a);
            OnItemLongClickListener onItemLongClickListener = this.xYC.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int g = HorizontalListViewV2.g(this.xYC) + a;
                if (onItemLongClickListener.onItemLongClick(this.xYC, childAt, g, this.xYC.FP.getItemId(g))) {
                    this.xYC.performHapticFeedback(0);
                }
            }
        }
    }
}
