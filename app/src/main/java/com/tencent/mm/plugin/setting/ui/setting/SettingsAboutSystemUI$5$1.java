package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.5;

class SettingsAboutSystemUI$5$1 implements OnCancelListener {
    final /* synthetic */ 5 qiv;

    SettingsAboutSystemUI$5$1(5 5) {
        this.qiv = 5;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.qiv.qin.isDeleteCancel = true;
    }
}
