package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomerScrollView extends ScrollView {
    private float zIA;
    private float zIB;
    private float zIC;
    private float zIz;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.zIA = 0.0f;
                this.zIz = 0.0f;
                this.zIB = motionEvent.getX();
                this.zIC = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.zIz += Math.abs(x - this.zIB);
                this.zIA += Math.abs(y - this.zIC);
                this.zIB = x;
                this.zIC = y;
                if (this.zIz > this.zIA) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
