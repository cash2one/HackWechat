package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.report.service.g;

class SettingsAboutMicroMsgUI$6 implements OnCancelListener {
    final /* synthetic */ SettingsAboutMicroMsgUI qie;

    SettingsAboutMicroMsgUI$6(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.qie = settingsAboutMicroMsgUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.pQN.a(405, 23, 1, true);
    }
}
