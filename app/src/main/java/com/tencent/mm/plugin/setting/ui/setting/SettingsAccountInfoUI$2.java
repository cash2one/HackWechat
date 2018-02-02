package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.z.ar;

class SettingsAccountInfoUI$2 implements OnCancelListener {
    final /* synthetic */ SettingsAccountInfoUI qiG;
    final /* synthetic */ x qiH;

    SettingsAccountInfoUI$2(SettingsAccountInfoUI settingsAccountInfoUI, x xVar) {
        this.qiG = settingsAccountInfoUI;
        this.qiH = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qiH);
    }
}
