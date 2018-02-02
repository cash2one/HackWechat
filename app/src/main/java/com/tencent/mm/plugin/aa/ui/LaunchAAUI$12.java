package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class LaunchAAUI$12 implements OnTouchListener {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$12(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.ijW.Xa();
        this.ijW.aWs();
        return false;
    }
}
