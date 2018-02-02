package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ServiceNotifySettingsUI$2 implements OnCancelListener {
    final /* synthetic */ ServiceNotifySettingsUI xMq;

    ServiceNotifySettingsUI$2(ServiceNotifySettingsUI serviceNotifySettingsUI) {
        this.xMq = serviceNotifySettingsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.xMq.finish();
    }
}
