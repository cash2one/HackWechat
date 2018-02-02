package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SettingsVoicePrintUI$6 implements OnClickListener {
    final /* synthetic */ SettingsVoicePrintUI shL;

    SettingsVoicePrintUI$6(SettingsVoicePrintUI settingsVoicePrintUI) {
        this.shL = settingsVoicePrintUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.shL.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
