package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class SettingDeleteAccountAgreementUI$1 implements OnClickListener {
    final /* synthetic */ SettingDeleteAccountAgreementUI qhO;

    SettingDeleteAccountAgreementUI$1(SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI) {
        this.qhO = settingDeleteAccountAgreementUI;
    }

    public final void onClick(View view) {
        this.qhO.startActivity(new Intent(this.qhO, SettingDeleteAccountInputPassUI.class));
    }
}
