package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsVoicePrintUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsVoicePrintUI shL;

    SettingsVoicePrintUI$3(SettingsVoicePrintUI settingsVoicePrintUI) {
        this.shL = settingsVoicePrintUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.shL.finish();
        return true;
    }
}
