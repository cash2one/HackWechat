package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsActiveTimeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsActiveTimeUI qiQ;

    SettingsActiveTimeUI$1(SettingsActiveTimeUI settingsActiveTimeUI) {
        this.qiQ = settingsActiveTimeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qiQ.aWs();
        this.qiQ.finish();
        return true;
    }
}
