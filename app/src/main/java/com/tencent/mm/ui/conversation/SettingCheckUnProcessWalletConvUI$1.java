package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingCheckUnProcessWalletConvUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI zaj;

    SettingCheckUnProcessWalletConvUI$1(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.zaj = settingCheckUnProcessWalletConvUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zaj.finish();
        return false;
    }
}
