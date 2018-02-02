package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.e.i.1;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class i$1$1 implements a {
    final /* synthetic */ 1 mFv;

    i$1$1(1 1) {
        this.mFv = 1;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.D(this.mFv.mFu.intent), Integer.valueOf(m.E(this.mFv.mFu.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            this.mFv.mFu.aMo();
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            i.a(this.mFv.mFu, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.D(this.mFv.mFu.intent), Integer.valueOf(m.E(this.mFv.mFu.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFv.mFu.mEZ;
            FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.mHb = m.a(this.mFv.mFu.mFb, b.mDa, 32);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.D(this.mFv.mFu.intent), Integer.valueOf(m.E(this.mFv.mFu.intent)), exception.getMessage(), m.f(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFv.mFu.mEZ;
        FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
        aVar.mHb = m.a(this.mFv.mFu.mFb, b.mDa, m.g(exception));
        freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
    }
}
