package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class SettingsUI$26 implements d {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$26(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                SettingsUI.d(this.qlF);
                return;
            case 2:
                SettingsUI.e(this.qlF);
                return;
            default:
                return;
        }
    }
}
