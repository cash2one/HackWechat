package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ a mBY;
    final /* synthetic */ c mBZ;

    public c$1(c cVar, a aVar) {
        this.mBZ = cVar;
        this.mBY = aVar;
    }

    public final void onSuccess() {
        x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[]{m.D(this.mBZ.activity.getIntent()), Integer.valueOf(m.E(this.mBZ.activity.getIntent()))});
        this.mBY.onSuccess();
    }

    public final void pQ(int i) {
        x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[]{m.D(this.mBZ.activity.getIntent()), Integer.valueOf(m.E(this.mBZ.activity.getIntent())), Integer.valueOf(i)});
        this.mBY.pQ(i);
    }
}
