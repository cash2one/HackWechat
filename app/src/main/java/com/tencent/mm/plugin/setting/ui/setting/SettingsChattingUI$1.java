package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsChattingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsChattingUI qji;

    SettingsChattingUI$1(SettingsChattingUI settingsChattingUI) {
        this.qji = settingsChattingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qji.aWs();
        this.qji.finish();
        return true;
    }
}
