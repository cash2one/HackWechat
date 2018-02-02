package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class RemittanceBusiUI$19 implements OnTouchListener {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$19(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (RemittanceBusiUI.q(this.pOd)) {
            RemittanceBusiUI.r(this.pOd);
        }
        return false;
    }
}
