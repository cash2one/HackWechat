package com.tencent.mm.plugin.gallery.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MultiGestureImageView$c extends SimpleOnGestureListener {
    final /* synthetic */ MultiGestureImageView mVw;

    private MultiGestureImageView$c(MultiGestureImageView multiGestureImageView) {
        this.mVw = multiGestureImageView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        return true;
    }
}
