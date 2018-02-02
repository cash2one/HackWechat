package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class SettingsUI$17 implements a {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$17(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final boolean uF() {
        ar.CG().b(281, SettingsUI.w(this.qlF));
        ar.CG().b(282, SettingsUI.y(this.qlF));
        SettingsUI.x(this.qlF);
        SettingsUI.z(this.qlF);
        if (SettingsUI.B(this.qlF) != null) {
            SettingsUI.B(this.qlF).TG();
        }
        if (SettingsUI.p(this.qlF) != null) {
            SettingsUI.p(this.qlF).cancel();
        }
        SettingsUI.A(this.qlF);
        return false;
    }
}
