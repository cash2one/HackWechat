package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class SettingsAboutSystemUI$6 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;

    SettingsAboutSystemUI$6(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.qin = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
        SettingsAboutSystemUI.d(this.qin);
        this.qin.startActivity(new Intent("android.settings.NFC_SETTINGS"));
    }
}
