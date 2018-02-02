package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class GameScrollView extends ScrollView {
    private GestureDetector jtw;

    public GameScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtw = new GestureDetector(context, new a(this));
        setFadingEdgeLength(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.jtw.onTouchEvent(motionEvent);
    }
}
