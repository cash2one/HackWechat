package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.setting.modelsimple.d;
import com.tencent.mm.z.ar;

class SettingsTrustFriendUI$5 implements OnCancelListener {
    final /* synthetic */ SettingsTrustFriendUI qlt;
    final /* synthetic */ d qlv;

    SettingsTrustFriendUI$5(SettingsTrustFriendUI settingsTrustFriendUI, d dVar) {
        this.qlt = settingsTrustFriendUI;
        this.qlv = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qlv);
    }
}
