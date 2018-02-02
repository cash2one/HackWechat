package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FtsBrowseHistorySettingsUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FtsBrowseHistorySettingsUI tDH;

    FtsBrowseHistorySettingsUI$1(FtsBrowseHistorySettingsUI ftsBrowseHistorySettingsUI) {
        this.tDH = ftsBrowseHistorySettingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tDH.finish();
        return true;
    }
}
