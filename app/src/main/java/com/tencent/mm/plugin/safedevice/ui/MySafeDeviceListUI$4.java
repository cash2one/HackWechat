package com.tencent.mm.plugin.safedevice.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class MySafeDeviceListUI$4 extends af {
    final /* synthetic */ MySafeDeviceListUI pRA;

    MySafeDeviceListUI$4(MySafeDeviceListUI mySafeDeviceListUI) {
        this.pRA = mySafeDeviceListUI;
    }

    public final void handleMessage(Message message) {
        MySafeDeviceListUI.b(this.pRA).notifyDataSetChanged();
        super.handleMessage(message);
    }
}
