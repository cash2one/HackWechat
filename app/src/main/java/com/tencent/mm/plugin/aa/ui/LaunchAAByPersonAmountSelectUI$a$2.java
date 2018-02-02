package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a;

class LaunchAAByPersonAmountSelectUI$a$2 implements OnTouchListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI$a$a ijn;
    final /* synthetic */ a ijo;

    LaunchAAByPersonAmountSelectUI$a$2(a aVar, LaunchAAByPersonAmountSelectUI$a$a launchAAByPersonAmountSelectUI$a$a) {
        this.ijo = aVar;
        this.ijn = launchAAByPersonAmountSelectUI$a$a;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.ijn.iiR.requestFocus();
        return false;
    }
}
