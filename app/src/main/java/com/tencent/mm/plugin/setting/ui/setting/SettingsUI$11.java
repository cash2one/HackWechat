package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.z.ar;

class SettingsUI$11 implements OnCancelListener {
    final /* synthetic */ x qii;
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$11(SettingsUI settingsUI, x xVar) {
        this.qlF = settingsUI;
        this.qii = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qii);
        ar.CG().b(255, SettingsUI.r(this.qlF));
        SettingsUI.s(this.qlF);
        if (SettingsUI.t(this.qlF) != null) {
            SettingsUI.t(this.qlF).TG();
            SettingsUI.u(this.qlF);
        }
        if (SettingsUI.p(this.qlF) != null) {
            SettingsUI.p(this.qlF).dismiss();
        }
    }
}
