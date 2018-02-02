package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class ProtocolThreeThreeUI$6 implements Runnable {
    final /* synthetic */ ProtocolThreeThreeUI mIT;
    final /* synthetic */ String val$url;

    ProtocolThreeThreeUI$6(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        this.mIT = protocolThreeThreeUI;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent())), this.val$url});
        a.aLn();
        a.a(this.val$url, new a.a(this) {
            final /* synthetic */ ProtocolThreeThreeUI$6 mIU;

            {
                this.mIU = r1;
            }

            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.D(this.mIU.mIT.getIntent()), Integer.valueOf(m.E(this.mIU.mIT.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    ProtocolThreeThreeUI.c(this.mIU.mIT);
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    ProtocolThreeThreeUI.a(this.mIU.mIT, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.D(this.mIU.mIT.getIntent()), Integer.valueOf(m.E(this.mIU.mIT.getIntent()))});
                    d.a(this.mIU.mIT.ssid, 3, this.mIU.mIT.getIntent());
                }
            }

            public final void h(Exception exception) {
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.D(this.mIU.mIT.getIntent()), Integer.valueOf(m.E(this.mIU.mIT.getIntent())), exception.getMessage()});
                d.a(this.mIU.mIT.ssid, 3, this.mIU.mIT.getIntent());
            }
        });
    }
}
