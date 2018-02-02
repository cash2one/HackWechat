package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.1;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiAuthStateUI$1$1 implements e {
    final /* synthetic */ 1 mGB;

    FreeWifiAuthStateUI$1$1(1 1) {
        this.mGB = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mGB.mGA.mGt = false;
        if (i == 0 && i2 == 0) {
            a aVar = (a) kVar;
            x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[]{aVar.aLW()});
            ei aMc = aVar.aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw});
                this.mGB.mGA.fFm = aMc.nkv;
                this.mGB.mGA.mFc = aMc.kub;
                this.mGB.mGA.fvL = aMc.ksU;
                this.mGB.mGA.mIq = aMc.vJH;
                this.mGB.mGA.mIr = aMc.vJI;
                this.mGB.mGA.signature = aMc.hvw;
                this.mGB.mGA.mIs = aMc.vJJ;
            }
            j.aLT().a(this.mGB.mGA.ssid, r0, this.mGB.mGA.getIntent());
        } else if (i2 == -2014) {
            d.a(this.mGB.mGA.ssid, -2014, this.mGB.mGA.getIntent());
        } else {
            d.a(this.mGB.mGA.ssid, 3, this.mGB.mGA.getIntent());
        }
    }
}
