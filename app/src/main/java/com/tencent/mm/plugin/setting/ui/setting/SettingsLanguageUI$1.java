package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsLanguageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsLanguageUI qjz;

    SettingsLanguageUI$1(SettingsLanguageUI settingsLanguageUI) {
        this.qjz = settingsLanguageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qjz.aWs();
        this.qjz.finish();
        return true;
    }
}
