package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$3 implements OnClickListener {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$3(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(11545, Integer.valueOf(2));
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.g(this.qlF) != null) {
            SettingsUI.g(this.qlF).dismiss();
        }
    }
}
