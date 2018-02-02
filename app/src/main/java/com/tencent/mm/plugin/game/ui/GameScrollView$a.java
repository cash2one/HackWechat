package com.tencent.mm.plugin.game.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class GameScrollView$a extends SimpleOnGestureListener {
    final /* synthetic */ GameScrollView nuL;

    GameScrollView$a(GameScrollView gameScrollView) {
        this.nuL = gameScrollView;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }
}
