package com.tencent.mm.ui.account;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SimpleLoginUI$14 implements OnTouchListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$14(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SimpleLoginUI.c(this.xSL).setFocusableInTouchMode(true);
        return SimpleLoginUI.c(this.xSL).sqw.onTouch(view, motionEvent);
    }
}
