package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class j$4 implements a {
    final /* synthetic */ j mFy;

    j$4(j jVar) {
        this.mFy = jVar;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.D(this.mFy.intent), Integer.valueOf(m.E(this.mFy.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            j.a(this.mFy, 0, "");
            m.a(this.mFy.intent, this.mFy.fpz, this.mFy.mFb, this.mFy.fdS, this.mFy.mEZ, "MicroMsg.FreeWifi.Protocol32");
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            j.a(this.mFy, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.D(this.mFy.intent), Integer.valueOf(m.E(this.mFy.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFy.mEZ;
            d dVar = d.mHC;
            FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.mHb = m.a(this.mFy.mFb, b.mCY, 32);
            freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
            j.a(this.mFy, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.D(this.mFy.intent), Integer.valueOf(m.E(this.mFy.intent)), exception.getMessage(), m.f(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFy.mEZ;
        d dVar = d.mHC;
        FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
        freeWifiFrontPageUI$a.mHb = m.a(this.mFy.mFb, b.mCY, m.g(exception));
        freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
        j.a(this.mFy, m.g(exception), m.e(exception));
    }
}
