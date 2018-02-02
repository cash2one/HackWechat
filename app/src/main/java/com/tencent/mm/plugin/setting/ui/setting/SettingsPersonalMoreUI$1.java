package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

class SettingsPersonalMoreUI$1 implements a {
    final /* synthetic */ SettingsPersonalMoreUI qkp;

    SettingsPersonalMoreUI$1(SettingsPersonalMoreUI settingsPersonalMoreUI) {
        this.qkp = settingsPersonalMoreUI;
    }

    public final boolean a(Preference preference, Object obj) {
        String str = (String) obj;
        if ("male".equalsIgnoreCase(str)) {
            SettingsPersonalMoreUI.a(this.qkp, 1);
        } else if ("female".equalsIgnoreCase(str)) {
            SettingsPersonalMoreUI.a(this.qkp, 2);
        }
        return false;
    }
}
