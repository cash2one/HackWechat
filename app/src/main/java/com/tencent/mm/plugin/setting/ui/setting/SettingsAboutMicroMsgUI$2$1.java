package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$2$1 implements e {
    final /* synthetic */ 2 qif;

    SettingsAboutMicroMsgUI$2$1(2 2) {
        this.qif = 2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(281, 2.a(this.qif));
        2.b(this.qif);
        if (2.c(this.qif) != null) {
            2.c(this.qif).TG();
            2.d(this.qif);
        }
        if (SettingsAboutMicroMsgUI.a(this.qif.qie) != null) {
            SettingsAboutMicroMsgUI.a(this.qif.qie).dismiss();
        }
        SettingsAboutMicroMsgUI.b(this.qif.qie);
    }
}
