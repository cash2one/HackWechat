package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class TouchInterceptorListView$1 extends SimpleOnGestureListener {
    final /* synthetic */ TouchInterceptorListView lEB;

    TouchInterceptorListView$1(TouchInterceptorListView touchInterceptorListView) {
        this.lEB = touchInterceptorListView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (TouchInterceptorListView.a(this.lEB) == null) {
            return false;
        }
        if (f > 1000.0f) {
            Rect b = TouchInterceptorListView.b(this.lEB);
            TouchInterceptorListView.a(this.lEB).getDrawingRect(b);
            if (motionEvent2.getX() > ((float) ((b.right * 2) / 3))) {
                TouchInterceptorListView.c(this.lEB);
                TouchInterceptorListView.d(this.lEB);
            }
        }
        return true;
    }
}
