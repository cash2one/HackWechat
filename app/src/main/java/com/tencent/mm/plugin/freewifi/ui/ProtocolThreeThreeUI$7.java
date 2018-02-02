package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeThreeUI$7 implements a {
    final /* synthetic */ ProtocolThreeThreeUI mIT;

    ProtocolThreeThreeUI$7(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.mIT = protocolThreeThreeUI;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent())), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            ProtocolThreeThreeUI.c(this.mIT);
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            ProtocolThreeThreeUI.a(this.mIT, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent()))});
            d.a(this.mIT.ssid, 3, this.mIT.getIntent());
        }
    }

    public final void h(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent())), exception.getMessage()});
    }
}
