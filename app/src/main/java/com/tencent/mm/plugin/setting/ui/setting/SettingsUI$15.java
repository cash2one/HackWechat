package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.modelsimple.am;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class SettingsUI$15 implements a {
    final /* synthetic */ am qig;
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$15(SettingsUI settingsUI, am amVar) {
        this.qlF = settingsUI;
        this.qig = amVar;
    }

    public final boolean uF() {
        ar.CG().c(this.qig);
        ar.CG().b(281, SettingsUI.w(this.qlF));
        ar.CG().b(282, SettingsUI.y(this.qlF));
        SettingsUI.x(this.qlF);
        SettingsUI.z(this.qlF);
        if (SettingsUI.t(this.qlF) != null) {
            SettingsUI.t(this.qlF).TG();
            SettingsUI.u(this.qlF);
        }
        if (SettingsUI.p(this.qlF) != null) {
            SettingsUI.p(this.qlF).cancel();
        }
        SettingsUI.A(this.qlF);
        return false;
    }
}
