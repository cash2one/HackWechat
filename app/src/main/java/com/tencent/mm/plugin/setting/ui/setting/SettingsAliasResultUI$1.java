package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAliasResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAliasResultUI qiX;

    SettingsAliasResultUI$1(SettingsAliasResultUI settingsAliasResultUI) {
        this.qiX = settingsAliasResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qiX.finish();
        return true;
    }
}
