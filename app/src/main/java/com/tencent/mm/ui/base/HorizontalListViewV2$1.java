package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class HorizontalListViewV2$1 implements OnTouchListener {
    final /* synthetic */ HorizontalListViewV2 xYC;

    HorizontalListViewV2$1(HorizontalListViewV2 horizontalListViewV2) {
        this.xYC = horizontalListViewV2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return HorizontalListViewV2.a(this.xYC).onTouchEvent(motionEvent);
    }
}
