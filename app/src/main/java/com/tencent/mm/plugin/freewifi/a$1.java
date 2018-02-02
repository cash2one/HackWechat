package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a mBT;
    final /* synthetic */ a mBU;

    a$1(a aVar, a aVar2) {
        this.mBU = aVar;
        this.mBT = aVar2;
    }

    public final void onSuccess() {
        x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", m.D(this.mBU.activity.getIntent()), Integer.valueOf(m.E(this.mBU.activity.getIntent())));
        this.mBT.onSuccess();
    }

    public final void pQ(int i) {
        x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", m.D(this.mBU.activity.getIntent()), Integer.valueOf(m.E(this.mBU.activity.getIntent())), Integer.valueOf(i));
        this.mBT.pQ(i);
    }
}
