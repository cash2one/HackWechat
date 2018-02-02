package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$4 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$4(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final void run() {
        Context context = this.lUq;
        this.lUq.getString(R.l.dGO);
        new ak(new 1(this, h.a(context, this.lUq.getString(R.l.ecE), false, null)), false).J(1000, 1000);
    }
}
