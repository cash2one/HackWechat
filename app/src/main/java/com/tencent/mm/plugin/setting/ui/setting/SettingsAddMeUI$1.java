package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAddMeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAddMeUI qiS;

    SettingsAddMeUI$1(SettingsAddMeUI settingsAddMeUI) {
        this.qiS = settingsAddMeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qiS.aWs();
        this.qiS.finish();
        return true;
    }
}
