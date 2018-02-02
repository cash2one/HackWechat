package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsManageFindMoreUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsManageFindMoreUI qjM;

    SettingsManageFindMoreUI$1(SettingsManageFindMoreUI settingsManageFindMoreUI) {
        this.qjM = settingsManageFindMoreUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qjM.finish();
        return true;
    }
}
