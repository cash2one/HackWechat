package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends e implements a {
    private String mBX = this.intent.getStringExtra("free_wifi_passowrd");

    public f(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mBX});
    }

    public final void connect() {
        c cVar = new c(this.ssid, this.mEZ, this.mBX);
        j.aLM();
        j.aLR().aLz().post(new 1(this, cVar));
    }
}
