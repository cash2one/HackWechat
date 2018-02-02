package com.tencent.mm.ui.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MMTextView$1 extends SimpleOnGestureListener {
    final /* synthetic */ MMTextView zvB;

    MMTextView$1(MMTextView mMTextView) {
        this.zvB = mMTextView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (MMTextView.a(this.zvB) == null) {
            return false;
        }
        return MMTextView.a(this.zvB).do(this.zvB);
    }
}
