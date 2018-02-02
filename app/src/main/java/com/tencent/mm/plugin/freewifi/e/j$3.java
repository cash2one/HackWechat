package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class j$3 implements Runnable {
    final /* synthetic */ j mFy;
    final /* synthetic */ String val$url;

    j$3(j jVar, String str) {
        this.mFy = jVar;
        this.val$url = str;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.D(this.mFy.intent), Integer.valueOf(m.E(this.mFy.intent)), this.val$url});
        a.aLn();
        a.a(this.val$url, new a$a(this) {
            final /* synthetic */ j$3 mFG;

            {
                this.mFG = r1;
            }

            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.D(this.mFG.mFy.intent), Integer.valueOf(m.E(this.mFG.mFy.intent)), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    j.a(this.mFG.mFy, 0, "");
                    m.a(this.mFG.mFy.intent, this.mFG.mFy.fpz, this.mFG.mFy.mFb, this.mFG.mFy.fdS, this.mFG.mFy.mEZ, "MicroMsg.FreeWifi.Protocol32");
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    j.a(this.mFG.mFy, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.D(this.mFG.mFy.intent), Integer.valueOf(m.E(this.mFG.mFy.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFG.mFy.mEZ;
                    d dVar = d.mHC;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.mHb = m.a(this.mFG.mFy.mFb, b.mCY, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    j.a(this.mFG.mFy, 32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.D(this.mFG.mFy.intent), Integer.valueOf(m.E(this.mFG.mFy.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFG.mFy.mEZ;
                d dVar = d.mHC;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.mHb = m.a(this.mFG.mFy.mFb, b.mCY, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                j.a(this.mFG.mFy, m.g(exception), m.e(exception));
            }
        });
    }
}
