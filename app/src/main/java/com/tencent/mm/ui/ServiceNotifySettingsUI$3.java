package com.tencent.mm.ui;

import android.database.DataSetObserver;
import com.tencent.mm.R;

class ServiceNotifySettingsUI$3 extends DataSetObserver {
    final /* synthetic */ ServiceNotifySettingsUI xMq;

    ServiceNotifySettingsUI$3(ServiceNotifySettingsUI serviceNotifySettingsUI) {
        this.xMq = serviceNotifySettingsUI;
    }

    public final void onChanged() {
        this.xMq.findViewById(R.h.csY).setVisibility(ServiceNotifySettingsUI.a(this.xMq).isEmpty() ? 4 : 0);
    }
}
