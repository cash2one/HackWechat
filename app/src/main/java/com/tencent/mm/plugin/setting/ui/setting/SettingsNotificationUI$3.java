package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.k.f;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsNotificationUI$3 implements OnClickListener {
    final /* synthetic */ SettingsNotificationUI qkm;

    SettingsNotificationUI$3(SettingsNotificationUI settingsNotificationUI) {
        this.qkm = settingsNotificationUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.bk(true);
        ((CheckBoxPreference) SettingsNotificationUI.a(this.qkm).YN("settings_new_voip_msg_notification")).tSw = true;
        this.qkm.initView();
    }
}
