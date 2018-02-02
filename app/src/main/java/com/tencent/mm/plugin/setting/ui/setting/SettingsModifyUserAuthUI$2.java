package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.setting.modelsimple.g;

class SettingsModifyUserAuthUI$2 implements OnCancelListener {
    final /* synthetic */ SettingsModifyUserAuthUI qkf;
    final /* synthetic */ g qkg;

    SettingsModifyUserAuthUI$2(SettingsModifyUserAuthUI settingsModifyUserAuthUI, g gVar) {
        this.qkf = settingsModifyUserAuthUI;
        this.qkg = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        com.tencent.mm.kernel.g.CG().c(this.qkg);
    }
}
