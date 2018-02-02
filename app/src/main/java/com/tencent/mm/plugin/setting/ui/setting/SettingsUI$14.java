package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.ar;

class SettingsUI$14 implements e {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$14(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ag.y(new Runnable(this) {
            final /* synthetic */ SettingsUI$14 qlH;

            {
                this.qlH = r1;
            }

            public final void run() {
                ar.CG().b(281, SettingsUI.w(this.qlH.qlF));
                SettingsUI.x(this.qlH.qlF);
            }
        });
    }
}
