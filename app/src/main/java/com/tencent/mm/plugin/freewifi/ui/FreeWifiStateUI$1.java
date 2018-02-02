package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiStateUI$1 implements a {
    final /* synthetic */ FreeWifiStateUI mIt;

    FreeWifiStateUI$1(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final boolean uF() {
        if (!bh.ov(this.mIt.ssid)) {
            FreeWifiStateUI.a(this.mIt, this.mIt.aMt());
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.mIt.ssid, Integer.valueOf(FreeWifiStateUI.a(this.mIt))});
            FreeWifiStateUI.b(this.mIt).TG();
            k.a aLe = k.aLe();
            aLe.ssid = this.mIt.ssid;
            aLe.fpz = this.mIt.fpz;
            aLe.mCu = m.D(this.mIt.getIntent());
            aLe.mCv = m.F(this.mIt.getIntent());
            aLe.mCw = b.mCH.mDi;
            aLe.mCx = b.mCH.name;
            aLe.result = -16;
            aLe.fCR = m.G(this.mIt.getIntent());
            aLe.mCt = this.mIt.fFm;
            aLe.mCy = this.mIt.fvL;
            aLe.aLg().aLf();
            if (FreeWifiStateUI.a(this.mIt) != 2) {
                this.mIt.aMx();
                this.mIt.aMv();
                d.a(this.mIt.ssid, 3, this.mIt.getIntent());
            }
        }
        return false;
    }
}
