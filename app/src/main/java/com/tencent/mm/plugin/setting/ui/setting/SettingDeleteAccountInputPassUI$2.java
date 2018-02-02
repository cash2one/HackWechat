package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountInputPassUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountInputPassUI qhR;

    SettingDeleteAccountInputPassUI$2(SettingDeleteAccountInputPassUI settingDeleteAccountInputPassUI) {
        this.qhR = settingDeleteAccountInputPassUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhR.aWs();
        this.qhR.startActivity(new Intent(this.qhR, SettingDeleteAccountUI.class));
        return true;
    }
}
