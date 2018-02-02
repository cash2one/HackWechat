package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MusicViewPager$b extends SimpleOnGestureListener {
    final /* synthetic */ MusicViewPager oNT;

    private MusicViewPager$b(MusicViewPager musicViewPager) {
        this.oNT = musicViewPager;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f2) < Math.abs(f)) {
            return true;
        }
        return false;
    }
}
