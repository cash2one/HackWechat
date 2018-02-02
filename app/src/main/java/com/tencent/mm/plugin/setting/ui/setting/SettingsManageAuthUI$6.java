package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsManageAuthUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsManageAuthUI qjE;

    SettingsManageAuthUI$6(SettingsManageAuthUI settingsManageAuthUI) {
        this.qjE = settingsManageAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 700) {
            SettingsManageAuthUI.a(this.qjE, true);
            SettingsManageAuthUI.d(this.qjE).notifyDataSetChanged();
            SettingsManageAuthUI.e(this.qjE);
        }
        return true;
    }
}
