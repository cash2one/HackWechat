package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.b;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.1;

class SettingsManageAuthUI$a$1$1 implements OnCancelListener {
    final /* synthetic */ b qjH;
    final /* synthetic */ 1 qjI;

    SettingsManageAuthUI$a$1$1(1 1, b bVar) {
        this.qjI = 1;
        this.qjH = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.CG().c(this.qjH);
    }
}
