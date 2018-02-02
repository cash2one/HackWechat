package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.modelsimple.am;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$2$2 implements a {
    final /* synthetic */ 2 qif;
    final /* synthetic */ am qig;

    SettingsAboutMicroMsgUI$2$2(2 2, am amVar) {
        this.qif = 2;
        this.qig = amVar;
    }

    public final boolean uF() {
        ar.CG().c(this.qig);
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
        return false;
    }
}
