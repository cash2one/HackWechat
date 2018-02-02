package com.tencent.mm.ui.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class b$1 extends SimpleOnGestureListener {
    final /* synthetic */ b zrk;

    b$1(b bVar) {
        this.zrk = bVar;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (b.a(this.zrk) && b.b(this.zrk)) {
            int width = b.c(this.zrk).getWidth() / 5;
            if (f > b.d(this.zrk)) {
                if (b.e(this.zrk) > (-width)) {
                    b.c(this.zrk).aF(f);
                }
            } else if (f < (-b.d(this.zrk)) && b.e(this.zrk) < width) {
                b.c(this.zrk).aF(f);
            }
            b.f(this.zrk);
        }
        return false;
    }
}
