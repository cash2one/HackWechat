package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9.1;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeTwoUI$9$1$1 implements a$a {
    final /* synthetic */ 1 mIZ;

    ProtocolThreeTwoUI$9$1$1(1 1) {
        this.mIZ = 1;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.D(this.mIZ.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIZ.mIY.mIW.getIntent()))});
            d.a(this.mIZ.mIY.mIW.ssid, 3, this.mIZ.mIY.mIW.getIntent());
            ProtocolThreeTwoUI.a(this.mIZ.mIY.mIW, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            1.a(this.mIZ, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.D(this.mIZ.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIZ.mIY.mIW.getIntent()))});
            d.a(this.mIZ.mIY.mIW.ssid, 3, this.mIZ.mIY.mIW.getIntent());
            ProtocolThreeTwoUI.a(this.mIZ.mIY.mIW, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.D(this.mIZ.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIZ.mIY.mIW.getIntent())), exception.getMessage()});
        d.a(this.mIZ.mIY.mIW.ssid, 3, this.mIZ.mIY.mIW.getIntent());
        ProtocolThreeTwoUI.a(this.mIZ.mIY.mIW, 101, m.e(exception));
    }
}
