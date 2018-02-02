package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;

class RegSetInfoUI$9 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ String xQX;
    final /* synthetic */ RegSetInfoUI xSg;
    final /* synthetic */ String xSh;
    final /* synthetic */ boolean xSi;
    final /* synthetic */ String xSj;
    final /* synthetic */ String xSk;
    final /* synthetic */ int xSl;

    RegSetInfoUI$9(RegSetInfoUI regSetInfoUI, k kVar, String str, String str2, boolean z, String str3, String str4, int i) {
        this.xSg = regSetInfoUI;
        this.flZ = kVar;
        this.xQX = str;
        this.xSh = str2;
        this.xSi = z;
        this.xSj = str3;
        this.xSk = str4;
        this.xSl = i;
    }

    public final void run() {
        RegSetInfoUI.b(this.xSg, ((y) this.flZ).Sh());
        aq.hfP.S("login_user_name", this.xQX);
        b.deleteFile(e.gHB + "temp.avatar");
        if (this.xSh == null || !this.xSh.contains("0")) {
            Intent at = a.ifs.at(this.xSg);
            at.addFlags(67108864);
            this.xSg.startActivity(at);
            com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + this.xSg.getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",4");
            this.xSg.finish();
            return;
        }
        com.tencent.mm.plugin.c.b.oH("R300_100_phone");
        if (this.xSi) {
            at = new Intent(this.xSg, FindMContactAlertUI.class);
            at.putExtra("alert_title", this.xSj);
            at.putExtra("alert_message", this.xSk);
        } else {
            at = new Intent(this.xSg, FindMContactIntroUI.class);
        }
        at.addFlags(67108864);
        at.putExtra("regsetinfo_ticket", RegSetInfoUI.g(this.xSg));
        at.putExtra("regsetinfo_NextStep", this.xSh);
        at.putExtra("regsetinfo_NextStyle", this.xSl);
        Intent at2 = a.ifs.at(this.xSg);
        at2.addFlags(67108864);
        MMWizardActivity.b(this.xSg, at, at2);
        this.xSg.finish();
    }
}
