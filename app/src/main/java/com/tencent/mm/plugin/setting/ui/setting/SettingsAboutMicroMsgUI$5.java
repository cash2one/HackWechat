package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$5 implements OnCancelListener {
    final /* synthetic */ SettingsAboutMicroMsgUI qie;
    final /* synthetic */ x qii;

    SettingsAboutMicroMsgUI$5(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI, x xVar) {
        this.qie = settingsAboutMicroMsgUI;
        this.qii = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qii);
        ar.CG().b(255, SettingsAboutMicroMsgUI.c(this.qie));
        SettingsAboutMicroMsgUI.d(this.qie);
        if (SettingsAboutMicroMsgUI.e(this.qie) != null) {
            SettingsAboutMicroMsgUI.e(this.qie).TG();
            SettingsAboutMicroMsgUI.f(this.qie);
        }
        if (SettingsAboutMicroMsgUI.a(this.qie) != null) {
            SettingsAboutMicroMsgUI.a(this.qie).dismiss();
        }
    }
}
