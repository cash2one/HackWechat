package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Message;
import com.tencent.mm.az.n;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.3;
import com.tencent.mm.sdk.platformtools.af;

class SettingsSelectBgUI$3$1 extends af {
    final /* synthetic */ n qla;
    final /* synthetic */ int qlb;
    final /* synthetic */ 3 qlc;

    SettingsSelectBgUI$3$1(3 3, n nVar, int i) {
        this.qlc = 3;
        this.qla = nVar;
        this.qlb = i;
    }

    public final void handleMessage(Message message) {
        this.qla.bi(this.qlb, 1);
    }
}
