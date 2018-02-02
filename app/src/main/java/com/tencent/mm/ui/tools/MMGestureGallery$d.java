package com.tencent.mm.ui.tools;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MMGestureGallery$d extends SimpleOnGestureListener {
    final /* synthetic */ MMGestureGallery zlk;

    private MMGestureGallery$d(MMGestureGallery mMGestureGallery) {
        this.zlk = mMGestureGallery;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        return true;
    }
}
