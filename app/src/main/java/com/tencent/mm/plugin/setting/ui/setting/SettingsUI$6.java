package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.z.ar;

class SettingsUI$6 implements e {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$6(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
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
    }
}
