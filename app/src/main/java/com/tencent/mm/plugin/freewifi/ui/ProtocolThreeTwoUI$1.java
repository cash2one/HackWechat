package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$1 implements a {
    final /* synthetic */ ProtocolThreeTwoUI mIW;

    ProtocolThreeTwoUI$1(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final boolean uF() {
        if (!bh.ov(this.mIW.ssid)) {
            ProtocolThreeTwoUI.a(this.mIW, this.mIW.aMt());
            if (ProtocolThreeTwoUI.a(this.mIW) != 2) {
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), d.pW(ProtocolThreeTwoUI.a(this.mIW))});
                d.a(this.mIW.ssid, 3, this.mIW.getIntent());
                ProtocolThreeTwoUI.a(this.mIW, 33, "AUTH_302_TIMES_EXCESS");
            }
        }
        return false;
    }
}
