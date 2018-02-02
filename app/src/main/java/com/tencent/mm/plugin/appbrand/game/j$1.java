package com.tencent.mm.plugin.appbrand.game;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class j$1 implements OnTouchListener {
    final /* synthetic */ j iXz;

    j$1(j jVar) {
        this.iXz = jVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j.a(this.iXz, motionEvent);
        return true;
    }
}
