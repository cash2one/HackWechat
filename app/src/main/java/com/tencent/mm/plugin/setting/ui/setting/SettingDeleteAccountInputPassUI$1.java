package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountInputPassUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountInputPassUI qhR;

    SettingDeleteAccountInputPassUI$1(SettingDeleteAccountInputPassUI settingDeleteAccountInputPassUI) {
        this.qhR = settingDeleteAccountInputPassUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhR.aWs();
        this.qhR.finish();
        return true;
    }
}
