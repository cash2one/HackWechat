package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAboutMicroMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAboutMicroMsgUI qie;

    SettingsAboutMicroMsgUI$1(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.qie = settingsAboutMicroMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qie.aWs();
        this.qie.finish();
        return true;
    }
}
