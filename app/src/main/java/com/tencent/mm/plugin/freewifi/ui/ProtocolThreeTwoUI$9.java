package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a$a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$9 implements a$a {
    final /* synthetic */ ProtocolThreeTwoUI mIW;

    ProtocolThreeTwoUI$9(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final void onSuccess() {
        a aLe = k.aLe();
        aLe.ssid = this.mIW.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32UI");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32UI");
        aLe.fpz = ProtocolThreeTwoUI.e(this.mIW);
        aLe.mCt = this.mIW.fFm;
        aLe.mCu = m.D(ProtocolThreeTwoUI.d(this.mIW));
        aLe.mCv = m.F(ProtocolThreeTwoUI.d(this.mIW));
        aLe.mCw = b.mCH.mDi;
        aLe.mCx = b.mCH.name;
        aLe.result = 0;
        aLe.fCR = m.G(ProtocolThreeTwoUI.d(this.mIW));
        aLe.mCy = this.mIW.fvL;
        aLe.aLg().aLf();
        String aLb = h.b.aLc().aLb();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), this.mIW.ssid, aLb});
        com.tencent.mm.plugin.freewifi.a.a.a 1 = new 1(this, aLb);
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(aLb, 1);
    }

    public final void pQ(int i) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), this.mIW.ssid, Integer.valueOf(i)});
        d.a(this.mIW.ssid, 3, this.mIW.getIntent());
        a aLe = k.aLe();
        aLe.ssid = this.mIW.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32UI");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32UI");
        aLe.fpz = ProtocolThreeTwoUI.e(this.mIW);
        aLe.mCt = this.mIW.fFm;
        aLe.mCu = m.D(ProtocolThreeTwoUI.d(this.mIW));
        aLe.mCv = m.F(ProtocolThreeTwoUI.d(this.mIW));
        aLe.mCw = b.mCH.mDi;
        aLe.mCx = b.mCH.name;
        aLe.result = i;
        aLe.fCR = m.G(ProtocolThreeTwoUI.d(this.mIW));
        aLe.mCy = this.mIW.fvL;
        aLe.aLg().aLf();
    }
}
