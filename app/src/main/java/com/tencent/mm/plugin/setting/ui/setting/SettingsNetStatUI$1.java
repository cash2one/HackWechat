package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsNetStatUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsNetStatUI qkl;

    SettingsNetStatUI$1(SettingsNetStatUI settingsNetStatUI) {
        this.qkl = settingsNetStatUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkl.aWs();
        this.qkl.finish();
        return true;
    }
}
