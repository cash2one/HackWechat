package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountAgreementUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountAgreementUI qhO;

    SettingDeleteAccountAgreementUI$3(SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI) {
        this.qhO = settingDeleteAccountAgreementUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhO.aWs();
        this.qhO.finish();
        return true;
    }
}
