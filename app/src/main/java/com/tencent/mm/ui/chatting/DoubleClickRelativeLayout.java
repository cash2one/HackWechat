package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.widget.MMTextView.b;

public class DoubleClickRelativeLayout extends RelativeLayout {
    public b yxa = null;
    private GestureDetector yxb = null;

    public DoubleClickRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DoubleClickRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.yxb = new GestureDetector(getContext(), new 1(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!(this.yxa == null || this.yxb == null)) {
            z = this.yxb.onTouchEvent(motionEvent);
        }
        if (z) {
            return z;
        }
        return super.onTouchEvent(motionEvent);
    }
}
