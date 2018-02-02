package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.modelsimple.x;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$4 implements a {
    final /* synthetic */ SettingsAboutMicroMsgUI qie;
    final /* synthetic */ x qii;

    SettingsAboutMicroMsgUI$4(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI, x xVar) {
        this.qie = settingsAboutMicroMsgUI;
        this.qii = xVar;
    }

    public final boolean uF() {
        ar.CG().c(this.qii);
        ar.CG().b(255, SettingsAboutMicroMsgUI.c(this.qie));
        SettingsAboutMicroMsgUI.d(this.qie);
        if (SettingsAboutMicroMsgUI.e(this.qie) != null) {
            SettingsAboutMicroMsgUI.e(this.qie).TG();
            SettingsAboutMicroMsgUI.f(this.qie);
        }
        if (SettingsAboutMicroMsgUI.a(this.qie) != null) {
            SettingsAboutMicroMsgUI.a(this.qie).cancel();
        }
        SettingsAboutMicroMsgUI.g(this.qie);
        return false;
    }
}
