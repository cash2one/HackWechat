package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ExdeviceConnectWifiUI$12 implements OnTouchListener {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$12(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ExdeviceConnectWifiUI.c(this.lTI).clearFocus();
        this.lTI.aWs();
        return false;
    }
}
