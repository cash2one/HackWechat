package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$8 implements Runnable {
    final /* synthetic */ ProtocolThreeOneUI mIQ;

    ProtocolThreeOneUI$8(ProtocolThreeOneUI protocolThreeOneUI) {
        this.mIQ = protocolThreeOneUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), this.mIQ.mFa, d.aLB(), d.aLD(), Integer.valueOf(d.aLC())});
        new a(this.mIQ.mFa, r2, r3, r4, this.mIQ.fdS, m.D(this.mIQ.getIntent())).b(new 1(this));
    }
}
