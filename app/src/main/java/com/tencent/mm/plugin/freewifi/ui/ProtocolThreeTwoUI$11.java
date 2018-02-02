package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeTwoUI$11 implements a$a {
    final /* synthetic */ ProtocolThreeTwoUI mIW;

    ProtocolThreeTwoUI$11(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            ProtocolThreeTwoUI.f(this.mIW);
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            ProtocolThreeTwoUI.b(this.mIW, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent()))});
            d.a(this.mIW.ssid, 3, this.mIW.getIntent());
            ProtocolThreeTwoUI.a(this.mIW, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.D(this.mIW.getIntent()), Integer.valueOf(m.E(this.mIW.getIntent())), exception.getMessage()});
        ProtocolThreeTwoUI.a(this.mIW, 101, m.e(exception));
    }
}
