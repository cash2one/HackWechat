package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.a;
import com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.2;
import com.tencent.mm.z.ar;

class SettingsMoreSafeUI$2$1 implements OnCancelListener {
    final /* synthetic */ a qkb;
    final /* synthetic */ 2 qkk;

    SettingsMoreSafeUI$2$1(2 2, a aVar) {
        this.qkk = 2;
        this.qkb = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qkb);
    }
}
