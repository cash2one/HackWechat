package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.z.ar;

class SettingsUI$16 implements OnCancelListener {
    final /* synthetic */ am qig;
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$16(SettingsUI settingsUI, am amVar) {
        this.qlF = settingsUI;
        this.qig = amVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
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
            SettingsUI.p(this.qlF).dismiss();
        }
    }
}
