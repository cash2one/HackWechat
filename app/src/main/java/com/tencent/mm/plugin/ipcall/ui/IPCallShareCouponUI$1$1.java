package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.1;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class IPCallShareCouponUI$1$1 implements Runnable {
    final /* synthetic */ 1 nNa;

    IPCallShareCouponUI$1$1(1 1) {
        this.nNa = 1;
    }

    public final void run() {
        ar.Hg();
        if (((Boolean) c.CU().get(a.xpo, Boolean.valueOf(false))).booleanValue()) {
            IPCallShareCouponUI.a(this.nNa.nMZ).setVisibility(0);
        } else {
            IPCallShareCouponUI.a(this.nNa.nMZ).setVisibility(8);
        }
        ar.Hg();
        IPCallShareCouponUI.b(this.nNa.nMZ).setText((String) c.CU().get(a.xpn, ""));
        ar.Hg();
        IPCallShareCouponUI.c(this.nNa.nMZ).setText((String) c.CU().get(a.xpp, ""));
    }
}
