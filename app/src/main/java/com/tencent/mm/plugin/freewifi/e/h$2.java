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

class h$2 implements a {
    final /* synthetic */ h mFn;

    h$2(h hVar) {
        this.mFn = hVar;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.D(this.mFn.intent), Integer.valueOf(m.E(this.mFn.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            h.a(this.mFn, 0, "");
            m.a(this.mFn.intent, this.mFn.fpz, this.mFn.mFb, this.mFn.fdS, this.mFn.mEZ, "MicroMsg.FreeWifi.ProtocolThreeOne");
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            h.a(this.mFn, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.D(this.mFn.intent), Integer.valueOf(m.E(this.mFn.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFn.mEZ;
            d dVar = d.mHC;
            FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.mHb = m.a(this.mFn.mFb, b.mCX, 32);
            freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
            h.a(this.mFn, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.D(this.mFn.intent), Integer.valueOf(m.E(this.mFn.intent)), exception.getMessage(), m.f(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFn.mEZ;
        d dVar = d.mHC;
        FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
        freeWifiFrontPageUI$a.mHb = m.a(this.mFn.mFb, b.mCX, m.g(exception));
        freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
        h.a(this.mFn, m.g(exception), m.e(exception));
    }
}
