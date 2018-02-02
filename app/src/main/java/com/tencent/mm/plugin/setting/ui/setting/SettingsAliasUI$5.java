package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class SettingsAliasUI$5 implements e {
    final /* synthetic */ SettingsAliasUI qjd;

    SettingsAliasUI$5(SettingsAliasUI settingsAliasUI) {
        this.qjd = settingsAliasUI;
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        x.d("MicroMsg.SettingsAliasUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        ar.CG().b(255, SettingsAliasUI.g(this.qjd));
        ag.y(new Runnable(this) {
            final /* synthetic */ SettingsAliasUI$5 qjf;

            public final void run() {
                if (SettingsAliasUI.h(this.qjf.qjd) != null) {
                    SettingsAliasUI.h(this.qjf.qjd).dismiss();
                    SettingsAliasUI.i(this.qjf.qjd);
                }
                SettingsAliasUI.j(this.qjf.qjd);
                if (kVar.getType() == 255) {
                    boolean z = (i2 == -3 && i == 4) ? false : true;
                    Intent intent = new Intent(this.qjf.qjd, SettingsAliasResultUI.class);
                    intent.putExtra("has_pwd", z);
                    this.qjf.qjd.startActivity(intent);
                    this.qjf.qjd.finish();
                }
            }
        });
    }
}
