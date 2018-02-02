package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class z$2 implements OnTouchListener {
    final /* synthetic */ z yhd;

    z$2(z zVar) {
        this.yhd = zVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.yhd.ygS = (int) motionEvent.getX();
        this.yhd.ygT = (int) motionEvent.getY();
        return false;
    }
}
