package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsAboutSystemUI$9 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;

    SettingsAboutSystemUI$9(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.qin = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qin.gZO.edit().putBoolean("settings_voicerecorder_mode", true).commit();
        ((CheckBoxPreference) SettingsAboutSystemUI.a(this.qin).YN("settings_voicerecorder_mode")).tSw = true;
        SettingsAboutSystemUI.a(this.qin).notifyDataSetChanged();
    }
}
