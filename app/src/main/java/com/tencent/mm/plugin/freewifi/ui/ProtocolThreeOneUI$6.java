package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$6 implements Runnable {
    final /* synthetic */ ProtocolThreeOneUI mIQ;
    final /* synthetic */ String val$url;

    ProtocolThreeOneUI$6(ProtocolThreeOneUI protocolThreeOneUI, String str) {
        this.mIQ = protocolThreeOneUI;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), this.val$url});
        a.aLn();
        a.a(this.val$url, new 1(this));
    }
}
