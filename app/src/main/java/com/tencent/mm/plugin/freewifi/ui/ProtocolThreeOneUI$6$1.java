package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.6;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeOneUI$6$1 implements a {
    final /* synthetic */ 6 mIR;

    ProtocolThreeOneUI$6$1(6 6) {
        this.mIR = 6;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.D(this.mIR.mIQ.getIntent()), Integer.valueOf(m.E(this.mIR.mIQ.getIntent())), Integer.valueOf(responseCode));
        if (!ProtocolThreeOneUI.d(this.mIR.mIQ)) {
            if (responseCode == 200) {
                ProtocolThreeOneUI.e(this.mIR.mIQ);
            } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                ProtocolThreeOneUI.a(this.mIR.mIQ, httpURLConnection.getHeaderField("Location"));
            } else {
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(this.mIR.mIQ.getIntent()), Integer.valueOf(m.E(this.mIR.mIQ.getIntent())));
                d.a(this.mIR.mIQ.ssid, 3, this.mIR.mIQ.getIntent());
                ProtocolThreeOneUI.a(this.mIR.mIQ, 32, "INVALID_HTTP_RESP_CODE");
            }
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.D(this.mIR.mIQ.getIntent()), Integer.valueOf(m.E(this.mIR.mIQ.getIntent())), exception.getMessage());
        d.a(this.mIR.mIQ.ssid, 3, this.mIR.mIQ.getIntent());
        ProtocolThreeOneUI.a(this.mIR.mIQ, 101, m.e(exception));
    }
}
