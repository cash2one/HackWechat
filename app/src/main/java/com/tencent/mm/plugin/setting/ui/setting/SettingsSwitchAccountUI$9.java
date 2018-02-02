package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;

class SettingsSwitchAccountUI$9 implements OnClickListener {
    final /* synthetic */ SettingsSwitchAccountUI qlm;

    SettingsSwitchAccountUI$9(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        this.qlm = settingsSwitchAccountUI;
    }

    public final void onClick(View view) {
        SettingsSwitchAccountUI.b(this.qlm, false);
        SettingsSwitchAccountUI.a(this.qlm, false);
        SettingsSwitchAccountUI.d(this.qlm).qmX = false;
        SettingsSwitchAccountUI.d(this.qlm).brm();
        SettingsSwitchAccountUI.e(this.qlm);
    }
}
