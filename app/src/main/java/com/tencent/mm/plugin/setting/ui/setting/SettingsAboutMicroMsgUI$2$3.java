package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$2$3 implements OnCancelListener {
    final /* synthetic */ 2 qif;
    final /* synthetic */ am qig;

    SettingsAboutMicroMsgUI$2$3(2 2, am amVar) {
        this.qif = 2;
        this.qig = amVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
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
    }
}
