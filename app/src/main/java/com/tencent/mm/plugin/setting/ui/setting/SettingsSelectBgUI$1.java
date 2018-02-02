package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;

class SettingsSelectBgUI$1 implements a {
    final /* synthetic */ SettingsSelectBgUI qkZ;

    SettingsSelectBgUI$1(SettingsSelectBgUI settingsSelectBgUI) {
        this.qkZ = settingsSelectBgUI;
    }

    public final boolean uF() {
        if (this.qkZ.findViewById(R.h.cMz).getWidth() <= 0) {
            return true;
        }
        SettingsSelectBgUI.a(this.qkZ);
        return false;
    }
}
