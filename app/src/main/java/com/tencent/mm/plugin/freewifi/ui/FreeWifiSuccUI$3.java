package com.tencent.mm.plugin.freewifi.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class FreeWifiSuccUI$3 implements OnCheckedChangeListener {
    final /* synthetic */ FreeWifiSuccUI mIG;

    FreeWifiSuccUI$3(FreeWifiSuccUI freeWifiSuccUI) {
        this.mIG = freeWifiSuccUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            FreeWifiSuccUI.a(this.mIG, true);
        } else {
            FreeWifiSuccUI.a(this.mIG, false);
        }
    }
}
