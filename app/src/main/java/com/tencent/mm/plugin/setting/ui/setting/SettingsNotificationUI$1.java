package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsNotificationUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsNotificationUI qkm;

    SettingsNotificationUI$1(SettingsNotificationUI settingsNotificationUI) {
        this.qkm = settingsNotificationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkm.aWs();
        this.qkm.finish();
        return true;
    }
}
