package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class SettingsAliasUI$4 implements OnCancelListener {
    final /* synthetic */ SettingsAliasUI qjd;

    SettingsAliasUI$4(SettingsAliasUI settingsAliasUI) {
        this.qjd = settingsAliasUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (SettingsAliasUI.f(this.qjd) != null) {
            ar.CG().c(SettingsAliasUI.f(this.qjd));
        }
    }
}
