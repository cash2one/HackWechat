package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d$1 implements OnTouchListener {
    final /* synthetic */ d jWe;

    d$1(d dVar) {
        this.jWe = dVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.jWe.dismiss();
        return true;
    }
}
