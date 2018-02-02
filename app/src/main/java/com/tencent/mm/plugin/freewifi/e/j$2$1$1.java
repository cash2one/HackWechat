package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.e.j.2.1;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class j$2$1$1 implements a {
    final /* synthetic */ 1 mFF;

    j$2$1$1(1 1) {
        this.mFF = 1;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.D(this.mFF.mFE.mFy.intent), Integer.valueOf(m.E(this.mFF.mFE.mFy.intent))});
            freeWifiFrontPageUI = this.mFF.mFE.mFy.mEZ;
            dVar = d.mHC;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.mHb = m.a(this.mFF.mFE.mFy.mFb, b.mCZ, 35);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.mFF.mFE.mFy, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            1.a(this.mFF, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.D(this.mFF.mFE.mFy.intent), Integer.valueOf(m.E(this.mFF.mFE.mFy.intent))});
            freeWifiFrontPageUI = this.mFF.mFE.mFy.mEZ;
            dVar = d.mHC;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.mHb = m.a(this.mFF.mFE.mFy.mFb, b.mCZ, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.mFF.mFE.mFy, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", new Object[]{m.D(this.mFF.mFE.mFy.intent), Integer.valueOf(m.E(this.mFF.mFE.mFy.intent)), exception.getMessage(), m.f(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFF.mFE.mFy.mEZ;
        d dVar = d.mHC;
        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
        aVar.mHb = m.a(this.mFF.mFE.mFy.mFb, b.mCZ, m.g(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
        j.a(this.mFF.mFE.mFy, m.g(exception), m.e(exception));
    }
}
