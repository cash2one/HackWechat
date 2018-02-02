package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.3;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$3$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ 3 qih;

    SettingsAboutMicroMsgUI$3$1(3 3, k kVar, int i, int i2) {
        this.qih = 3;
        this.flZ = kVar;
        this.fmb = i;
        this.fma = i2;
    }

    public final void run() {
        ar.CG().b(255, SettingsAboutMicroMsgUI.c(this.qih.qie));
        SettingsAboutMicroMsgUI.d(this.qih.qie);
        if (SettingsAboutMicroMsgUI.e(this.qih.qie) != null) {
            SettingsAboutMicroMsgUI.e(this.qih.qie).TG();
            SettingsAboutMicroMsgUI.f(this.qih.qie);
        }
        if (SettingsAboutMicroMsgUI.a(this.qih.qie) != null) {
            SettingsAboutMicroMsgUI.a(this.qih.qie).dismiss();
        }
        if (this.flZ.getType() != 255 || ((x) this.flZ).hNL != 1) {
            return;
        }
        if (this.fmb == -3 && this.fma == 4) {
            Intent intent = new Intent(this.qih.qie.mController.xIM, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", this.qih.qie.getString(R.l.eDT));
            this.qih.qie.startActivityForResult(intent, 0);
            return;
        }
        SettingsAboutMicroMsgUI.g(this.qih.qie);
    }
}
