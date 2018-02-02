package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class FreewifiWeChatNoAuthStateUI$1 implements e {
    final /* synthetic */ FreewifiWeChatNoAuthStateUI mIO;

    FreewifiWeChatNoAuthStateUI$1(FreewifiWeChatNoAuthStateUI freewifiWeChatNoAuthStateUI) {
        this.mIO = freewifiWeChatNoAuthStateUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(640, this);
        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
            ei aMc = ((a) kVar).aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw});
                this.mIO.fFm = aMc.nkv;
                this.mIO.mFc = aMc.kub;
                this.mIO.fvL = aMc.ksU;
                this.mIO.mIq = aMc.vJH;
                this.mIO.mIr = aMc.vJI;
                this.mIO.signature = aMc.hvw;
                this.mIO.mIs = aMc.vJJ;
            }
            d.a(this.mIO.ssid, 2, this.mIO.getIntent());
            return;
        }
        x.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(this.mIO)), FreewifiWeChatNoAuthStateUI.b(this.mIO), FreewifiWeChatNoAuthStateUI.c(this.mIO)});
        d.a(this.mIO.ssid, -2014, this.mIO.getIntent());
        d.AL(FreewifiWeChatNoAuthStateUI.c(this.mIO));
    }
}
