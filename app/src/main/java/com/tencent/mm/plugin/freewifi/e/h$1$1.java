package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.e.h.1;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class h$1$1 implements a {
    final /* synthetic */ 1 mFo;

    h$1$1(1 1) {
        this.mFo = 1;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.D(this.mFo.mFn.intent), Integer.valueOf(m.E(this.mFo.mFn.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            h.a(this.mFo.mFn, 0, "");
            m.a(this.mFo.mFn.intent, this.mFo.mFn.fpz, this.mFo.mFn.mFb, this.mFo.mFn.fdS, this.mFo.mFn.mEZ, "MicroMsg.FreeWifi.ProtocolThreeOne");
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            h.a(this.mFo.mFn, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.D(this.mFo.mFn.intent), Integer.valueOf(m.E(this.mFo.mFn.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFo.mFn.mEZ;
            d dVar = d.mHC;
            FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.mHb = m.a(this.mFo.mFn.mFb, b.mCX, 32);
            freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
            h.a(this.mFo.mFn, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[]{m.D(this.mFo.mFn.intent), Integer.valueOf(m.E(this.mFo.mFn.intent)), exception.getMessage(), m.f(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFo.mFn.mEZ;
        d dVar = d.mHC;
        FreeWifiFrontPageUI$a freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
        freeWifiFrontPageUI$a.mHb = m.a(this.mFo.mFn.mFb, b.mCX, m.g(exception));
        freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
        h.a(this.mFo.mFn, m.g(exception), m.e(exception));
    }
}
