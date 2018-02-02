package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAccountInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAccountInfoUI qiG;

    SettingsAccountInfoUI$1(SettingsAccountInfoUI settingsAccountInfoUI) {
        this.qiG = settingsAccountInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qiG.aWs();
        this.qiG.finish();
        return true;
    }
}
