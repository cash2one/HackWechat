package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.z.ar;

class SettingsUI$9 implements e {
    final /* synthetic */ SettingsUI qlF;

    SettingsUI$9(SettingsUI settingsUI) {
        this.qlF = settingsUI;
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        x.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        ag.y(new Runnable(this) {
            final /* synthetic */ SettingsUI$9 qlG;

            public final void run() {
                ar.CG().b(255, SettingsUI.r(this.qlG.qlF));
                SettingsUI.s(this.qlG.qlF);
                if (SettingsUI.t(this.qlG.qlF) != null) {
                    SettingsUI.t(this.qlG.qlF).TG();
                    SettingsUI.u(this.qlG.qlF);
                }
                if (SettingsUI.p(this.qlG.qlF) != null) {
                    SettingsUI.p(this.qlG.qlF).dismiss();
                }
                if (kVar.getType() != 255 || ((com.tencent.mm.modelsimple.x) kVar).hNL != 2) {
                    return;
                }
                if (i2 == -3 && i == 4) {
                    Intent intent = new Intent(this.qlG.qlF.mController.xIM, RegByMobileSetPwdUI.class);
                    intent.putExtra("kintent_hint", this.qlG.qlF.getString(R.l.eDT));
                    this.qlG.qlF.startActivityForResult(intent, 5);
                    return;
                }
                SettingsUI.v(this.qlG.qlF);
            }
        });
    }
}
