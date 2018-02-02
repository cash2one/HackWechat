package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.10;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeTwoUI$10$1 implements a {
    final /* synthetic */ 10 mJa;

    ProtocolThreeTwoUI$10$1(10 10) {
        this.mJa = 10;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.D(this.mJa.mIW.getIntent()), Integer.valueOf(m.E(this.mJa.mIW.getIntent())), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            ProtocolThreeTwoUI.f(this.mJa.mIW);
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            ProtocolThreeTwoUI.b(this.mJa.mIW, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.D(this.mJa.mIW.getIntent()), Integer.valueOf(m.E(this.mJa.mIW.getIntent()))});
            d.a(this.mJa.mIW.ssid, 3, this.mJa.mIW.getIntent());
            this.mJa.mIW.ag(32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.D(this.mJa.mIW.getIntent()), Integer.valueOf(m.E(this.mJa.mIW.getIntent())), exception.getMessage()});
        d.a(this.mJa.mIW.ssid, 3, this.mJa.mIW.getIntent());
        this.mJa.mIW.ag(101, m.e(exception));
    }
}
