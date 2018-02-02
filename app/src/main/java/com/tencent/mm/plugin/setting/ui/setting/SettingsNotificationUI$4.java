package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ui.base.h$a;

class SettingsNotificationUI$4 implements h$a {
    final /* synthetic */ int iVx;
    final /* synthetic */ SettingsNotificationUI qkm;

    SettingsNotificationUI$4(SettingsNotificationUI settingsNotificationUI, int i) {
        this.qkm = settingsNotificationUI;
        this.iVx = i;
    }

    public final void vm(int i) {
        if (this.iVx != i) {
            SettingsNotificationUI.vW(i);
        }
    }
}
