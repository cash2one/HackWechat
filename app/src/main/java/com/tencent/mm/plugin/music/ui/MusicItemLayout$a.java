package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.plugin.music.ui.b.a;

class MusicItemLayout$a extends SimpleOnGestureListener {
    final /* synthetic */ MusicItemLayout oNj;

    private MusicItemLayout$a(MusicItemLayout musicItemLayout) {
        this.oNj = musicItemLayout;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f2) > Math.abs(f)) {
            a aVar = (a) this.oNj.getTag();
            if (f2 > 0.0f) {
                aVar.beJ();
            } else {
                aVar.beI();
            }
        }
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        a aVar = (a) this.oNj.getTag();
        if (aVar.beH()) {
            if (motionEvent.getY() <= ((float) aVar.oNv.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                aVar.beK();
            }
        } else if (motionEvent.getY() >= aVar.oNy.getY() - 100.0f && motionEvent.getY() < ((float) aVar.oNy.getMeasuredHeight()) + aVar.oNy.getY()) {
            aVar.beK();
        }
        return false;
    }
}
