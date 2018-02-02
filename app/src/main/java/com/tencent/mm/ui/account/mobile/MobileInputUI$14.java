package com.tencent.mm.ui.account.mobile;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MobileInputUI$14 implements OnTouchListener {
    final /* synthetic */ MobileInputUI xUi;

    MobileInputUI$14(MobileInputUI mobileInputUI) {
        this.xUi = mobileInputUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.xUi.aWs();
        return false;
    }
}
