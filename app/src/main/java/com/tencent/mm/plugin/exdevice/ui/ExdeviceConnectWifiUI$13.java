package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$13 implements OnClickListener {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$13(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
        ExdeviceConnectWifiUI.a(this.lTI, ExdeviceConnectWifiUI.k(this.lTI));
    }
}
