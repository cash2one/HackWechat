package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsRingtoneUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsRingtoneUI qkJ;

    SettingsRingtoneUI$1(SettingsRingtoneUI settingsRingtoneUI) {
        this.qkJ = settingsRingtoneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkJ.aWs();
        this.qkJ.finish();
        return true;
    }
}
