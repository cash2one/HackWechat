package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SettingsAccountInfoUI$4 implements OnClickListener {
    final /* synthetic */ SettingsAccountInfoUI qiG;

    SettingsAccountInfoUI$4(SettingsAccountInfoUI settingsAccountInfoUI) {
        this.qiG = settingsAccountInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsAccountInfoUI.a(this.qiG).setText("");
        SettingsAccountInfoUI.b(this.qiG).dismiss();
    }
}
