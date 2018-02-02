package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

class g$2 extends c {
    final /* synthetic */ g iDU;

    g$2(g gVar) {
        this.iDU = gVar;
    }

    public final void enter() {
        super.enter();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        car com_tencent_mm_protocal_c_car = new car();
        com_tencent_mm_protocal_c_car.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[]{Integer.valueOf(g.a(this.iDU))});
        com_tencent_mm_protocal_c_car.version = g.a(this.iDU);
        com_tencent_mm_protocal_c_car.fqR = g.c(this.iDU);
        com_tencent_mm_protocal_c_car.wFT = 1;
        f.Zo().a(com_tencent_mm_protocal_c_car, new PInt());
        aj.a(com_tencent_mm_protocal_c_car.url, com_tencent_mm_protocal_c_car.version, new 1(this));
    }
}
