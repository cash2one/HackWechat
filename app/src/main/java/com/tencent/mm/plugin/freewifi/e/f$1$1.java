package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.e.f.1;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;

class f$1$1 implements a {
    final /* synthetic */ 1 mFf;

    f$1$1(1 1) {
        this.mFf = 1;
    }

    public final void onSuccess() {
        x.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[]{m.D(this.mFf.mFe.intent), Integer.valueOf(m.E(this.mFf.mFe.intent))});
        k.a aLe = k.aLe();
        aLe.ssid = this.mFf.mFe.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.ProtocolFour");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.ProtocolFour");
        aLe.fpz = this.mFf.mFe.fpz;
        aLe.mCt = this.mFf.mFe.appId;
        aLe.mCu = m.D(this.mFf.mFe.intent);
        aLe.mCv = m.F(this.mFf.mFe.intent);
        aLe.mCw = b.mCH.mDi;
        aLe.mCx = b.mCH.name;
        aLe.result = 0;
        aLe.fCR = m.G(this.mFf.mFe.intent);
        aLe.aLg().aLf();
        m.a(this.mFf.mFe.intent, this.mFf.mFe.fpz, this.mFf.mFe.mFb, this.mFf.mFe.fdS, this.mFf.mFe.mEZ, "MicroMsg.FreeWifi.ProtocolFour");
    }

    public final void pQ(int i) {
        x.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.D(this.mFf.mFe.intent), Integer.valueOf(m.E(this.mFf.mFe.intent)), this.mFf.mFe.ssid, Integer.valueOf(i)});
        k.a aLe = k.aLe();
        aLe.ssid = this.mFf.mFe.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.ProtocolFour");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.ProtocolFour");
        aLe.fpz = this.mFf.mFe.fpz;
        aLe.mCt = this.mFf.mFe.appId;
        aLe.mCu = m.D(this.mFf.mFe.intent);
        aLe.mCv = m.F(this.mFf.mFe.intent);
        aLe.mCw = b.mCH.mDi;
        aLe.mCx = b.mCH.name;
        aLe.result = i;
        aLe.fCR = m.G(this.mFf.mFe.intent);
        aLe.aLg().aLf();
        if (i == -16) {
            this.mFf.mFe.intent.setClass(this.mFf.mFe.mEZ.mController.xIM, FreeWifiCopyPwdUI.class);
            this.mFf.mFe.mEZ.finish();
            this.mFf.mFe.mEZ.startActivity(this.mFf.mFe.intent);
        } else if (i == -14 || i == -18) {
            r0 = this.mFf.mFe.mEZ;
            r1 = d.mHC;
            r2 = new FreeWifiFrontPageUI.a();
            r2.jCk = R.l.ejB;
            r2.mHb = m.a(this.mFf.mFe.mFb, b.mCH, i);
            r0.a(r1, r2);
        } else {
            r0 = this.mFf.mFe.mEZ;
            r1 = d.mHC;
            r2 = new FreeWifiFrontPageUI.a();
            r2.jCk = R.l.ejA;
            r2.mHb = m.a(this.mFf.mFe.mFb, b.mCH, i);
            r0.a(r1, r2);
        }
    }
}
