package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$20 implements e {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$20(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        ag.y(new 1(this, kVar, i2, i));
    }
}
