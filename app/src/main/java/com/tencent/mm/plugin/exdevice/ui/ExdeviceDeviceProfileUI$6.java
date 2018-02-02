package com.tencent.mm.plugin.exdevice.ui;

import android.widget.Toast;
import com.tencent.mm.R;

class ExdeviceDeviceProfileUI$6 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$6(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final void run() {
        Toast.makeText(this.lUq.mController.xIM, R.l.edO, 1).show();
    }
}
