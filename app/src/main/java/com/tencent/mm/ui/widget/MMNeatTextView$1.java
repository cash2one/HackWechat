package com.tencent.mm.ui.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MMNeatTextView$1 extends SimpleOnGestureListener {
    final /* synthetic */ MMNeatTextView ztZ;

    MMNeatTextView$1(MMNeatTextView mMNeatTextView) {
        this.ztZ = mMNeatTextView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.ztZ.zLw == null) {
            return false;
        }
        return this.ztZ.zLw.dF(this.ztZ);
    }
}
