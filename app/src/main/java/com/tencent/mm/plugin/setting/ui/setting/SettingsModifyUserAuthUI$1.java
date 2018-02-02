package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsModifyUserAuthUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyUserAuthUI qkf;

    SettingsModifyUserAuthUI$1(SettingsModifyUserAuthUI settingsModifyUserAuthUI) {
        this.qkf = settingsModifyUserAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkf.finish();
        return true;
    }
}
