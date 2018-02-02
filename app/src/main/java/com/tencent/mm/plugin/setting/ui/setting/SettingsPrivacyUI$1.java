package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class SettingsPrivacyUI$1 implements Runnable {
    final /* synthetic */ int laD;
    final /* synthetic */ SettingsPrivacyUI qkC;

    SettingsPrivacyUI$1(SettingsPrivacyUI settingsPrivacyUI, int i) {
        this.qkC = settingsPrivacyUI;
        this.laD = i;
    }

    public final void run() {
        View a = ((a) SettingsPrivacyUI.a(this.qkC)).a(this.laD, this.qkC.nKG);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.qkC.mController.xIM, a);
        }
    }
}
