package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsAboutTimelineUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAboutTimelineUI qiz;

    SettingsAboutTimelineUI$1(SettingsAboutTimelineUI settingsAboutTimelineUI) {
        this.qiz = settingsAboutTimelineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qiz.aWs();
        this.qiz.finish();
        return true;
    }
}
