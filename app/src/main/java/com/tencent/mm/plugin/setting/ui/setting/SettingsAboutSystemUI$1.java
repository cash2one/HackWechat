package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAboutSystemUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;

    SettingsAboutSystemUI$1(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.qin = settingsAboutSystemUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qin.aWs();
        this.qin.finish();
        return true;
    }
}
