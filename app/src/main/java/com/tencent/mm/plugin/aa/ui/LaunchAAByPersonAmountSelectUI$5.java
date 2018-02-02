package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.wxpay.a.c;

class LaunchAAByPersonAmountSelectUI$5 implements OnTouchListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;

    LaunchAAByPersonAmountSelectUI$5(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        this.ijj = launchAAByPersonAmountSelectUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!LaunchAAByPersonAmountSelectUI.k(this.ijj)) {
            return true;
        }
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            LaunchAAByPersonAmountSelectUI.l(this.ijj).setTextColor(this.ijj.getResources().getColor(c.brC));
        } else if (LaunchAAByPersonAmountSelectUI.k(this.ijj)) {
            LaunchAAByPersonAmountSelectUI.l(this.ijj).setTextColor(this.ijj.getResources().getColor(c.brB));
        } else {
            LaunchAAByPersonAmountSelectUI.l(this.ijj).setTextColor(this.ijj.getResources().getColor(c.uaH));
        }
        return false;
    }
}
