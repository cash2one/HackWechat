package com.tencent.mm.ui.account.mobile;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;

class MobileLoginOrForceReg$6 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ String xQX;
    final /* synthetic */ MobileLoginOrForceReg xUx;

    MobileLoginOrForceReg$6(MobileLoginOrForceReg mobileLoginOrForceReg, k kVar, String str) {
        this.xUx = mobileLoginOrForceReg;
        this.flZ = kVar;
        this.xQX = str;
    }

    public final void run() {
        MobileLoginOrForceReg.a(this.xUx, ((y) this.flZ).Sh());
        aq.hfP.S("login_user_name", this.xQX);
        Intent at = a.ifs.at(this.xUx);
        at.addFlags(67108864);
        this.xUx.startActivity(at);
        b.oI(ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",4");
        this.xUx.finish();
    }
}
