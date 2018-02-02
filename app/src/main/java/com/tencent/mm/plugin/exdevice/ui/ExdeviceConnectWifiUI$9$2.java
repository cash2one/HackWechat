package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.9;
import com.tencent.mm.ui.base.h;

class ExdeviceConnectWifiUI$9$2 implements Runnable {
    final /* synthetic */ 9 lTQ;

    ExdeviceConnectWifiUI$9$2(9 9) {
        this.lTQ = 9;
    }

    public final void run() {
        ExdeviceConnectWifiUI.g(this.lTQ.lTI).dismiss();
        h.a(this.lTQ.lTI.mController.xIM, this.lTQ.lTI.mController.xIM.getString(R.l.ecn), "", this.lTQ.lTI.mController.xIM.getString(R.l.ecM), "", false, new 1(this), null).show();
    }
}
