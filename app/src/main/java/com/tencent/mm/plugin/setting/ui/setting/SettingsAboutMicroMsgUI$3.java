package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SettingsAboutMicroMsgUI$3 implements e {
    final /* synthetic */ SettingsAboutMicroMsgUI qie;

    SettingsAboutMicroMsgUI$3(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.qie = settingsAboutMicroMsgUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        ag.y(new 1(this, kVar, i2, i));
    }
}
