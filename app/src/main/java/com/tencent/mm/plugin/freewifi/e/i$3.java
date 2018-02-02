package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements Runnable {
    final /* synthetic */ i mFu;

    i$3(i iVar) {
        this.mFu = iVar;
    }

    public final void run() {
        a aLe = k.aLe();
        aLe.ssid = this.mFu.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol33");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol33");
        aLe.fpz = this.mFu.fpz;
        aLe.mCu = m.D(this.mFu.intent);
        aLe.mCv = this.mFu.mFb;
        aLe.mCw = b.mCK.mDi;
        aLe.mCx = b.mCK.name;
        aLe.fCR = m.G(this.mFu.intent);
        aLe.result = 0;
        aLe.aLg().aLf();
        String aLB = d.aLB();
        String aLD = d.aLD();
        int aLC = d.aLC();
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.D(this.mFu.intent), Integer.valueOf(m.E(this.mFu.intent)), "", aLB, aLD, Integer.valueOf(aLC)});
        new f(this.mFu.ssid, m.AE("MicroMsg.FreeWifi.Protocol33"), this.mFu.appId, this.mFu.mFp, this.mFu.mFq, this.mFu.mFr, this.mFu.fqD, this.mFu.sign).b(new 1(this));
    }
}
