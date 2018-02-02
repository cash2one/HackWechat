package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;

class RegByMobileSendSmsUI$5 implements Runnable {
    final /* synthetic */ RegByMobileSendSmsUI xQV;
    final /* synthetic */ y xQW;
    final /* synthetic */ String xQX;

    RegByMobileSendSmsUI$5(RegByMobileSendSmsUI regByMobileSendSmsUI, y yVar, String str) {
        this.xQV = regByMobileSendSmsUI;
        this.xQW = yVar;
        this.xQX = str;
    }

    public final void run() {
        RegByMobileSendSmsUI.a(this.xQV, this.xQW.Sh());
        aq.hfP.S("login_user_name", this.xQX);
        Intent at = a.ifs.at(this.xQV);
        at.addFlags(67108864);
        this.xQV.startActivity(at);
        b.oI(ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",4");
        this.xQV.finish();
    }
}
