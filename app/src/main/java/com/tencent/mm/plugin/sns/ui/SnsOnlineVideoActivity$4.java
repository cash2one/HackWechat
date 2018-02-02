package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class SnsOnlineVideoActivity$4 extends SimpleOnGestureListener {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$4(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
        float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
        if (Math.abs(rawX) <= ((float) SnsOnlineVideoActivity.a(this.rEF).getWidth()) && Math.abs(rawY) <= ((float) SnsOnlineVideoActivity.a(this.rEF).getHeight()) && SnsOnlineVideoActivity.b(this.rEF)) {
            SnsOnlineVideoActivity.c(this.rEF).setTranslationX(rawX);
            SnsOnlineVideoActivity.c(this.rEF).setTranslationY(rawY);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        SnsOnlineVideoActivity.a(this.rEF, true);
        super.onLongPress(motionEvent);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        this.rEF.avV();
        return super.onSingleTapUp(motionEvent);
    }
}
