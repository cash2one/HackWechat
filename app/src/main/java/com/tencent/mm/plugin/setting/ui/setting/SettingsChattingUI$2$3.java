package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2;

class SettingsChattingUI$2$3 implements OnClickListener {
    final /* synthetic */ 2 qjj;

    SettingsChattingUI$2$3(2 2) {
        this.qjj = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, Integer.valueOf(5), Integer.valueOf(3), "");
        SettingsChattingUI.a(this.qjj.qji).show();
        SettingsChattingUI.a(this.qjj.qji, false);
        SettingsChattingUI.b(this.qjj.qji);
    }
}
