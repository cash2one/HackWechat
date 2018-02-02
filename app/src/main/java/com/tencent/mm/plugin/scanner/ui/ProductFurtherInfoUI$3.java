package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ProductFurtherInfoUI$3 implements OnTouchListener {
    final /* synthetic */ ProductFurtherInfoUI pVB;

    ProductFurtherInfoUI$3(ProductFurtherInfoUI productFurtherInfoUI) {
        this.pVB = productFurtherInfoUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(view == null || view.getParent() == null)) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }
}
