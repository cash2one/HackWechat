package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.modelsimple.x;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class SettingsUI$21 implements a {
    final /* synthetic */ x qii;
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$21(SettingsUI settingsUI, x xVar) {
        this.qlF = settingsUI;
        this.qii = xVar;
    }

    public final boolean uF() {
        ar.CG().c(this.qii);
        ar.CG().b(255, SettingsUI.r(this.qlF));
        SettingsUI.s(this.qlF);
        if (SettingsUI.t(this.qlF) != null) {
            SettingsUI.t(this.qlF).TG();
            SettingsUI.u(this.qlF);
        }
        if (SettingsUI.p(this.qlF) != null) {
            SettingsUI.p(this.qlF).cancel();
        }
        SettingsUI.C(this.qlF);
        return false;
    }
}
