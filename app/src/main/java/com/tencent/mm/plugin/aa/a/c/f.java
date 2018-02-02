package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.g;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;

public class f extends a {
    c ihA = new c();
    g ihB = new g();
    j ihC = new j();

    protected final void onCreate() {
        super.onCreate();
        e WC = this.ihA.WC();
        x.i("MicroMsg.AAGetPaylistDetailLogic", "init");
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(1695, WC);
        WC = this.ihB.WI();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(1629, WC);
        this.ihC.WL().init();
    }

    protected final void onDestroy() {
        super.onDestroy();
        e WC = this.ihA.WC();
        x.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(1695, WC);
        WC = this.ihB.WI();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(1629, WC);
        this.ihC.WL().WK();
    }
}
