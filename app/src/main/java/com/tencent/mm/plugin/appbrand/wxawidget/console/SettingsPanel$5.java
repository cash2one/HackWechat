package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class SettingsPanel$5 implements OnClickListener {
    final /* synthetic */ SettingsPanel khW;

    SettingsPanel$5(SettingsPanel settingsPanel) {
        this.khW = settingsPanel;
    }

    public final void onClick(View view) {
        if (SettingsPanel.d(this.khW) != null) {
            SettingsPanel.d(this.khW).onClick(view);
        }
    }
}
