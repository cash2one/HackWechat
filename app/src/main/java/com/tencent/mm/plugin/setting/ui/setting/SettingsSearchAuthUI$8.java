package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.h;

class SettingsSearchAuthUI$8 implements OnCancelListener {
    final /* synthetic */ SettingsSearchAuthUI qkQ;
    final /* synthetic */ h qkR;

    SettingsSearchAuthUI$8(SettingsSearchAuthUI settingsSearchAuthUI, h hVar) {
        this.qkQ = settingsSearchAuthUI;
        this.qkR = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.CG().c(this.qkR);
    }
}
