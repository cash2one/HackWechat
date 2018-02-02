package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.setting.modelsimple.a;
import com.tencent.mm.z.ar;

class SettingsTrustFriendUI$2 implements OnCancelListener {
    final /* synthetic */ SettingsTrustFriendUI qlt;
    final /* synthetic */ a qlu;

    SettingsTrustFriendUI$2(SettingsTrustFriendUI settingsTrustFriendUI, a aVar) {
        this.qlt = settingsTrustFriendUI;
        this.qlu = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qlu);
    }
}
