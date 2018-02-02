package com.tencent.mm.plugin.label.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ContactLabelUI$6 implements OnTouchListener {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$6(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.nPX.aWs();
        }
        return false;
    }
}
