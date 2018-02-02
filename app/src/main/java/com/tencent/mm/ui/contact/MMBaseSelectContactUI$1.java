package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMBaseSelectContactUI$1 implements OnTouchListener {
    final /* synthetic */ MMBaseSelectContactUI yTk;

    MMBaseSelectContactUI$1(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.yTk = mMBaseSelectContactUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMBaseSelectContactUI.a(this.yTk);
        this.yTk.cwf();
        this.yTk.cwg();
        return false;
    }
}
