package com.tencent.mm.ui.applet;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class b$2 implements OnGestureListener {
    final /* synthetic */ b xWc;

    b$2(b bVar) {
        this.xWc = bVar;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.xWc.direction = f2 >= 0.0f ? 0 : 1;
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
