package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class FreewifiActivateWeChatNoAuthStateUI$1 implements e {
    final /* synthetic */ FreewifiActivateWeChatNoAuthStateUI mIN;

    FreewifiActivateWeChatNoAuthStateUI$1(FreewifiActivateWeChatNoAuthStateUI freewifiActivateWeChatNoAuthStateUI) {
        this.mIN = freewifiActivateWeChatNoAuthStateUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(640, this);
        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
            d.a(this.mIN.ssid, 2, this.mIN.getIntent());
            return;
        }
        x.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(this.mIN)), FreewifiActivateWeChatNoAuthStateUI.b(this.mIN), FreewifiActivateWeChatNoAuthStateUI.c(this.mIN)});
        this.mIN.pi(-2014);
        d.AL(FreewifiActivateWeChatNoAuthStateUI.c(this.mIN));
    }
}
