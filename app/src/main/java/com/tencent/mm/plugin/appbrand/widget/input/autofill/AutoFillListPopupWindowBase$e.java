package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AutoFillListPopupWindowBase$e implements OnTouchListener {
    final /* synthetic */ AutoFillListPopupWindowBase kaA;

    private AutoFillListPopupWindowBase$e(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.kaA = autoFillListPopupWindowBase;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && AutoFillListPopupWindowBase.b(this.kaA) != null && AutoFillListPopupWindowBase.b(this.kaA).isShowing() && x >= 0 && x < AutoFillListPopupWindowBase.b(this.kaA).getWidth() && y >= 0 && y < AutoFillListPopupWindowBase.b(this.kaA).getHeight()) {
            AutoFillListPopupWindowBase.d(this.kaA).postDelayed(AutoFillListPopupWindowBase.c(this.kaA), 250);
        } else if (action == 1) {
            AutoFillListPopupWindowBase.d(this.kaA).removeCallbacks(AutoFillListPopupWindowBase.c(this.kaA));
        }
        return false;
    }
}
