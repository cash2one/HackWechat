package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsModifyNameUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyNameUI qkd;

    SettingsModifyNameUI$4(SettingsModifyNameUI settingsModifyNameUI) {
        this.qkd = settingsModifyNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkd.aWs();
        this.qkd.finish();
        return true;
    }
}
