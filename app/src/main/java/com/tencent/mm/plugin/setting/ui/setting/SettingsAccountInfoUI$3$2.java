package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI.3;
import com.tencent.mm.z.ar;

class SettingsAccountInfoUI$3$2 implements OnCancelListener {
    final /* synthetic */ 3 qiI;
    final /* synthetic */ al qiJ;

    SettingsAccountInfoUI$3$2(3 3, al alVar) {
        this.qiI = 3;
        this.qiJ = alVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qiJ);
    }
}
