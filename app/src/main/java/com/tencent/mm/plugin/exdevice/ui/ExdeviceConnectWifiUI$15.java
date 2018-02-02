package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class ExdeviceConnectWifiUI$15 implements OnKeyListener {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$15(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        ExdeviceConnectWifiUI.a(this.lTI, ExdeviceConnectWifiUI.k(this.lTI));
        return true;
    }
}
