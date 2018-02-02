package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsAboutSystemUI$4 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;
    final /* synthetic */ CheckBoxPreference qit;
    final /* synthetic */ boolean qiu;

    SettingsAboutSystemUI$4(SettingsAboutSystemUI settingsAboutSystemUI, CheckBoxPreference checkBoxPreference, boolean z) {
        this.qin = settingsAboutSystemUI;
        this.qit = checkBoxPreference;
        this.qiu = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qit.tSw = this.qiu;
        SettingsAboutSystemUI.a(this.qin).notifyDataSetChanged();
    }
}
