package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$8 implements OnClickListener {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$8(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final void onClick(View view) {
        h.a(this.lUq, this.lUq.getString(R.l.edf), "", "", 50, ExdeviceDeviceProfileUI.e(this.lUq));
    }
}
