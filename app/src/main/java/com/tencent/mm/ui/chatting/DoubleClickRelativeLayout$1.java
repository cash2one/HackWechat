package com.tencent.mm.ui.chatting;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DoubleClickRelativeLayout$1 extends SimpleOnGestureListener {
    final /* synthetic */ DoubleClickRelativeLayout yxc;

    DoubleClickRelativeLayout$1(DoubleClickRelativeLayout doubleClickRelativeLayout) {
        this.yxc = doubleClickRelativeLayout;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (DoubleClickRelativeLayout.a(this.yxc) == null) {
            return false;
        }
        return DoubleClickRelativeLayout.a(this.yxc).do(this.yxc);
    }
}
