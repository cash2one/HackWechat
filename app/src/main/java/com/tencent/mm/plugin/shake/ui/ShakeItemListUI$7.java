package com.tencent.mm.plugin.shake.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ShakeItemListUI$7 implements OnTouchListener {
    final /* synthetic */ ShakeItemListUI qqB;

    ShakeItemListUI$7(ShakeItemListUI shakeItemListUI) {
        this.qqB = shakeItemListUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (ShakeItemListUI.b(this.qqB) != null) {
            ShakeItemListUI$a b = ShakeItemListUI.b(this.qqB);
            if (b.hvU != null) {
                b.hvU.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
