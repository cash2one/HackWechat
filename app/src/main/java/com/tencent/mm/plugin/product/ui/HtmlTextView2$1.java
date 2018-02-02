package com.tencent.mm.plugin.product.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class HtmlTextView2$1 implements OnTouchListener {
    final /* synthetic */ HtmlTextView2 pff;

    HtmlTextView2$1(HtmlTextView2 htmlTextView2) {
        this.pff = htmlTextView2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
    }
}
