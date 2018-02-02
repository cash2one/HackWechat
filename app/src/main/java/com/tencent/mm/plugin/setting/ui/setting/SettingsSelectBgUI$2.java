package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsSelectBgUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsSelectBgUI qkZ;

    SettingsSelectBgUI$2(SettingsSelectBgUI settingsSelectBgUI) {
        this.qkZ = settingsSelectBgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkZ.finish();
        return true;
    }
}
