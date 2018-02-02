package com.tencent.mm.ui.account;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SimpleLoginUI$15 implements OnTouchListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$15(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SimpleLoginUI.d(this.xSL).setFocusableInTouchMode(true);
        SimpleLoginUI.c(this.xSL).setFocusableInTouchMode(false);
        return SimpleLoginUI.d(this.xSL).sqw.onTouch(view, motionEvent);
    }
}
