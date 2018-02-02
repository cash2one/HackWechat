package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceConnectWifiUI$5 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$5(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void run() {
        ExdeviceConnectWifiUI exdeviceConnectWifiUI = this.lTI;
        Context context = this.lTI.mController.xIM;
        this.lTI.getString(R.l.dGO);
        ExdeviceConnectWifiUI.a(exdeviceConnectWifiUI, h.a(context, this.lTI.getString(R.l.edK), true, new 1(this)));
    }
}
