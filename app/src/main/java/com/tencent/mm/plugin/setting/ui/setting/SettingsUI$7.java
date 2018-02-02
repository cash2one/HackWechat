package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.modelsimple.am;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class SettingsUI$7 implements a {
    final /* synthetic */ am qig;
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$7(SettingsUI settingsUI, am amVar) {
        this.qlF = settingsUI;
        this.qig = amVar;
    }

    public final boolean uF() {
        ar.CG().c(this.qig);
        ar.CG().b(281, SettingsUI.l(this.qlF));
        SettingsUI.m(this.qlF);
        if (SettingsUI.n(this.qlF) != null) {
            SettingsUI.n(this.qlF).TG();
            SettingsUI.o(this.qlF);
        }
        if (SettingsUI.p(this.qlF) != null) {
            SettingsUI.p(this.qlF).dismiss();
        }
        SettingsUI.q(this.qlF);
        return false;
    }
}
