package com.tencent.mm.ui.account.mobile;

import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.z.ar;

class h$4 extends b {
    final /* synthetic */ k flZ;
    final /* synthetic */ Boolean xUA;
    final /* synthetic */ h xUN;
    final /* synthetic */ String xUy;
    final /* synthetic */ String xUz;

    h$4(h hVar, String str, String str2, k kVar, Boolean bool) {
        this.xUN = hVar;
        this.xUy = str;
        this.xUz = str2;
        this.flZ = kVar;
        this.xUA = bool;
    }

    public final void cnJ() {
        this.xUN.xUE.aWs();
        ar.CG().a(126, this.xUN);
        k yVar = new y("", this.xUy, this.xUz, 0, "", this.xUN.xUE.fAf, "", "", this.xUN.xUL, this.xUN.xUE.hNU, "", ((y) this.flZ).Op(), "", true, this.xUA.booleanValue());
        yVar.mx(this.xUN.xUE.xOW);
        ar.CG().a(yVar, 0);
    }
}
