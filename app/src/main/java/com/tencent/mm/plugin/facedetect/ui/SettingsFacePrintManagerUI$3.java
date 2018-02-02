package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsFacePrintManagerUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsFacePrintManagerUI mkP;

    SettingsFacePrintManagerUI$3(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        this.mkP = settingsFacePrintManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mkP.finish();
        return true;
    }
}
