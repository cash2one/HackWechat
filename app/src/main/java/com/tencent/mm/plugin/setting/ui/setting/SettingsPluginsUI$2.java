package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsPluginsUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsPluginsUI qkv;

    SettingsPluginsUI$2(SettingsPluginsUI settingsPluginsUI) {
        this.qkv = settingsPluginsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkv.aWs();
        this.qkv.finish();
        return true;
    }
}
