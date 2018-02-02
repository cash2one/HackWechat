package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsUI$23 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$23(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qlF.finish();
        return true;
    }
}
