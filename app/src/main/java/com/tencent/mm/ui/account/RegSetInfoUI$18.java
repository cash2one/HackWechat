package com.tencent.mm.ui.account;

import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.z.ar;

class RegSetInfoUI$18 extends b {
    final /* synthetic */ k flZ;
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$18(RegSetInfoUI regSetInfoUI, k kVar) {
        this.xSg = regSetInfoUI;
        this.flZ = kVar;
    }

    public final void cnJ() {
        this.xSg.aWs();
        int e = RegSetInfoUI.e(this.xSg);
        String f = RegSetInfoUI.f(this.xSg);
        ar.CG().a(429, this.xSg);
        ar.CG().a(new x(f, RegSetInfoUI.g(this.xSg), e, "", "", ((x) this.flZ).Op(), ""), 0);
    }
}
