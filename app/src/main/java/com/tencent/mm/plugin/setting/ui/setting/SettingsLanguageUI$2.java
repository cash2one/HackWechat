package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsLanguageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsLanguageUI qjz;

    SettingsLanguageUI$2(SettingsLanguageUI settingsLanguageUI) {
        this.qjz = settingsLanguageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qjz.finish();
        SettingsLanguageUI.a(this.qjz, SettingsLanguageUI.a(this.qjz), SettingsLanguageUI.b(this.qjz));
        return true;
    }
}
