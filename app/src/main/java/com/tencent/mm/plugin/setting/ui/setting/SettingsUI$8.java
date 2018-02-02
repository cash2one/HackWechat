package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.z.ar;

class SettingsUI$8 implements OnCancelListener {
    final /* synthetic */ am qig;
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$8(SettingsUI settingsUI, am amVar) {
        this.qlF = settingsUI;
        this.qig = amVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
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
    }
}
