package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$8 implements Runnable {
    final /* synthetic */ ProtocolThreeThreeUI mIT;

    ProtocolThreeThreeUI$8(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.mIT = protocolThreeThreeUI;
    }

    public final void run() {
        String aLB = d.aLB();
        String aLD = d.aLD();
        int aLC = d.aLC();
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent())), "", aLB, aLD, Integer.valueOf(aLC)});
        new f(this.mIT.ssid, this.mIT.bssid, this.mIT.appId, this.mIT.mFp, this.mIT.mFq, this.mIT.mFr, this.mIT.fqD, this.mIT.sign).b(new 1(this));
    }
}
