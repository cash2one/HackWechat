package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.setting.ui.setting.SettingsUI.20;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.z.ar;

class SettingsUI$20$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ 20 qlJ;

    SettingsUI$20$1(20 20, k kVar, int i, int i2) {
        this.qlJ = 20;
        this.flZ = kVar;
        this.fmb = i;
        this.fma = i2;
    }

    public final void run() {
        ar.CG().b(255, SettingsUI.r(this.qlJ.qlF));
        SettingsUI.s(this.qlJ.qlF);
        if (SettingsUI.t(this.qlJ.qlF) != null) {
            SettingsUI.t(this.qlJ.qlF).TG();
            SettingsUI.u(this.qlJ.qlF);
        }
        if (SettingsUI.p(this.qlJ.qlF) != null) {
            SettingsUI.p(this.qlJ.qlF).dismiss();
        }
        if (this.flZ.getType() != 255 || ((x) this.flZ).hNL != 1) {
            return;
        }
        if (this.fmb == -3 && this.fma == 4) {
            Intent intent = new Intent(this.qlJ.qlF.mController.xIM, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", this.qlJ.qlF.getString(R.l.eDT));
            this.qlJ.qlF.startActivityForResult(intent, 0);
            return;
        }
        SettingsUI.C(this.qlJ.qlF);
    }
}
