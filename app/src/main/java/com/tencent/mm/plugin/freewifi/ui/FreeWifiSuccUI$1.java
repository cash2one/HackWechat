package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FreeWifiSuccUI$1 implements OnClickListener {
    final /* synthetic */ FreeWifiSuccUI mIG;

    FreeWifiSuccUI$1(FreeWifiSuccUI freeWifiSuccUI) {
        this.mIG = freeWifiSuccUI;
    }

    public final void onClick(View view) {
        this.mIG.finish();
        FreeWifiSuccUI.a(this.mIG);
    }
}
