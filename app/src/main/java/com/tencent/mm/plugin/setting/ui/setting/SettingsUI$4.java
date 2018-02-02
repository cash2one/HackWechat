package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelstat.c;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class SettingsUI$4 implements OnClickListener {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$4(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.SO().SP();
        if (SettingsUI.i(this.qlF) == null || !SettingsUI.i(this.qlF).isChecked()) {
            x.i("MicroMsg.SettingsUI", "normally exit");
            g.pQN.a(99, 144, 1, false);
            g.pQN.h(11545, Integer.valueOf(7));
            x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
            if (!(ar.CG() == null || ar.CG().hmV == null)) {
                ar.CG().hmV.bF(false);
            }
            SettingsUI.k(this.qlF);
            return;
        }
        x.i("MicroMsg.SettingsUI", "push notify mode exit");
        g.pQN.a(99, 143, 1, false);
        g.pQN.h(11545, Integer.valueOf(6));
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
        aa.VJ().edit().putBoolean("is_in_notify_mode", true).commit();
        SettingsUI.j(this.qlF);
    }
}
