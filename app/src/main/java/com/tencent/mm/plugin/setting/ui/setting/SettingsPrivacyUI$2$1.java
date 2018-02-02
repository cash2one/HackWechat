package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.2;

class SettingsPrivacyUI$2$1 implements Runnable {
    final /* synthetic */ 2 qkD;

    SettingsPrivacyUI$2$1(2 2) {
        this.qkD = 2;
    }

    public final void run() {
        ((Dialog) this.qkD.qio.getTag()).dismiss();
        SettingsPrivacyUI.h(this.qkD.qkC);
    }
}
