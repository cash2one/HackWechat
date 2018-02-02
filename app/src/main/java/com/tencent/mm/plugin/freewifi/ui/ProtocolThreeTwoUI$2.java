package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$2 implements Runnable {
    final /* synthetic */ ProtocolThreeTwoUI mIW;

    ProtocolThreeTwoUI$2(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), this.mIW.mFa, d.aLB(), d.aLD(), Integer.valueOf(d.aLC())});
        new a(this.mIW.mFa, r2, r3, r4, this.mIW.fdS, m.D(this.mIW.getIntent())).b(new 1(this));
    }
}
