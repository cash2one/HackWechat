package com.tencent.mm.plugin.aa.ui;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1;

class BaseAAPresenterActivity$1$2 implements Runnable {
    final /* synthetic */ 1 iiP;

    BaseAAPresenterActivity$1$2(1 1) {
        this.iiP = 1;
    }

    public final void run() {
        this.iiP.iiO.Xa();
        ((InputMethodManager) this.iiP.iiO.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiP.iiL, 0);
    }
}
