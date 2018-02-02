package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAliasUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAliasUI qjd;

    SettingsAliasUI$2(SettingsAliasUI settingsAliasUI) {
        this.qjd = settingsAliasUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qjd.aWs();
        this.qjd.finish();
        return true;
    }
}
