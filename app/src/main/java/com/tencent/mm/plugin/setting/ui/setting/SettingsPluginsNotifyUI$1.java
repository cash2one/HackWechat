package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsPluginsNotifyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsPluginsNotifyUI qkq;

    SettingsPluginsNotifyUI$1(SettingsPluginsNotifyUI settingsPluginsNotifyUI) {
        this.qkq = settingsPluginsNotifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkq.aWs();
        this.qkq.finish();
        return true;
    }
}
