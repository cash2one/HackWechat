package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class SettingsUI$18 implements OnCancelListener {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$18(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
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
