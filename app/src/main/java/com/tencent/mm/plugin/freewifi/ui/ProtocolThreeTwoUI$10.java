package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$10 implements Runnable {
    final /* synthetic */ ProtocolThreeTwoUI mIW;
    final /* synthetic */ String val$url;

    ProtocolThreeTwoUI$10(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        this.mIW = protocolThreeTwoUI;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), this.val$url);
        a.aLn();
        a.a(this.val$url, new 1(this));
    }
}
