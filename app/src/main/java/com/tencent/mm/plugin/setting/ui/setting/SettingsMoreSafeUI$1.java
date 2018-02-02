package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsMoreSafeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsMoreSafeUI qkj;

    SettingsMoreSafeUI$1(SettingsMoreSafeUI settingsMoreSafeUI) {
        this.qkj = settingsMoreSafeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkj.aWs();
        this.qkj.finish();
        return true;
    }
}
