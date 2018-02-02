package com.tencent.mm.plugin.exdevice.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class ExdeviceProfileUI$a extends SimpleOnGestureListener {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    private ExdeviceProfileUI$a(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f2) < Math.abs(f)) {
            return true;
        }
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
