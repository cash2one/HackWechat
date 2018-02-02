package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$1 implements a {
    final /* synthetic */ ProtocolThreeThreeUI mIT;

    ProtocolThreeThreeUI$1(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.mIT = protocolThreeThreeUI;
    }

    public final boolean uF() {
        if (!bh.ov(this.mIT.ssid)) {
            ProtocolThreeThreeUI.a(this.mIT, this.mIT.aMt());
            if (ProtocolThreeThreeUI.a(this.mIT) != 2) {
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent())), d.pW(ProtocolThreeThreeUI.a(this.mIT))});
                d.a(this.mIT.ssid, 3, this.mIT.getIntent());
            }
        }
        return false;
    }
}
