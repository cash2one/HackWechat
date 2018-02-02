package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountUI qhS;

    SettingDeleteAccountUI$1(SettingDeleteAccountUI settingDeleteAccountUI) {
        this.qhS = settingDeleteAccountUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhS.aWs();
        this.qhS.finish();
        return true;
    }
}
