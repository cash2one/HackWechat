package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.bq;

class SettingsUI$19 implements e {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$19(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String RW = ((u) kVar).RW();
        x.i("MicroMsg.SettingsUI", "logout return");
        if (bh.ov(RW)) {
            x.i("MicroMsg.SettingsUI", "no pwd ticket is null!");
        }
        String H = aq.hfP.H("login_weixin_username", "");
        if (bq.hhK.ia(H)) {
            bq.hhK.j(H, "last_logout_no_pwd_ticket", RW);
        }
        ag.y(new 1(this));
    }
}
