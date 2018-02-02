package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMListPopupWindow$e implements OnTouchListener {
    final /* synthetic */ MMListPopupWindow ybW;

    private MMListPopupWindow$e(MMListPopupWindow mMListPopupWindow) {
        this.ybW = mMListPopupWindow;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && MMListPopupWindow.b(this.ybW) != null && MMListPopupWindow.b(this.ybW).isShowing() && x >= 0 && x < MMListPopupWindow.b(this.ybW).getWidth() && y >= 0 && y < MMListPopupWindow.b(this.ybW).getHeight()) {
            MMListPopupWindow.d(this.ybW).postDelayed(MMListPopupWindow.c(this.ybW), 250);
        } else if (action == 1) {
            MMListPopupWindow.d(this.ybW).removeCallbacks(MMListPopupWindow.c(this.ybW));
        }
        return false;
    }
}
