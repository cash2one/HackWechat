package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MySafeDeviceListUI$5 implements OnClickListener {
    final /* synthetic */ MySafeDeviceListUI pRA;
    final /* synthetic */ boolean pRC;

    MySafeDeviceListUI$5(MySafeDeviceListUI mySafeDeviceListUI, boolean z) {
        this.pRA = mySafeDeviceListUI;
        this.pRC = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MySafeDeviceListUI.a(this.pRA, this.pRC);
        MySafeDeviceListUI.b(this.pRA, MySafeDeviceListUI.c(this.pRA));
        MySafeDeviceListUI.bou();
    }
}
