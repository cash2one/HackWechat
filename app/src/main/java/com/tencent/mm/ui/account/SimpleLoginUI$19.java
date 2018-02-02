package com.tencent.mm.ui.account;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SimpleLoginUI$19 implements OnTouchListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$19(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.xSL.aWs();
        return false;
    }
}
