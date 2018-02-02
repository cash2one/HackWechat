package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class c$6 implements OnTouchListener {
    final /* synthetic */ c nXi;

    c$6(c cVar) {
        this.nXi = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.nXi.aWs();
        return false;
    }
}
