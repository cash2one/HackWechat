package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class SettingsUI$2 implements OnClickListener {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$2(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(11545, Integer.valueOf(3));
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        g.pQN.a(99, 145, 1, false);
        if (!(ar.CG() == null || ar.CG().hmV == null)) {
            ar.CG().hmV.bF(false);
        }
        if (SettingsUI.g(this.qlF) != null) {
            SettingsUI.g(this.qlF).dismiss();
        }
        SettingsUI.h(this.qlF);
    }
}
