package com.tencent.mm.plugin.record.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d$2 implements OnTouchListener {
    final /* synthetic */ d pGS;

    d$2(d dVar) {
        this.pGS = dVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.pGS.kGp = (int) motionEvent.getRawX();
            this.pGS.kGq = (int) motionEvent.getRawY();
        }
        return false;
    }
}
