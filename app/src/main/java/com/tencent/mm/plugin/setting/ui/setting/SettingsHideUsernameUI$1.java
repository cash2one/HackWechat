package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsHideUsernameUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsHideUsernameUI qju;

    SettingsHideUsernameUI$1(SettingsHideUsernameUI settingsHideUsernameUI) {
        this.qju = settingsHideUsernameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qju.finish();
        return true;
    }
}
