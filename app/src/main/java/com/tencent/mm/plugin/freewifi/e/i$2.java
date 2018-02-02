package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

class i$2 implements a$a {
    final /* synthetic */ i mFu;

    i$2(i iVar) {
        this.mFu = iVar;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.D(this.mFu.intent), Integer.valueOf(m.E(this.mFu.intent)), Integer.valueOf(responseCode)});
        if (responseCode == 200) {
            this.mFu.aMo();
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            i.a(this.mFu, httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.D(this.mFu.intent), Integer.valueOf(m.E(this.mFu.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFu.mEZ;
            d dVar = d.mHC;
            a aVar = new a();
            aVar.mHb = m.a(this.mFu.mFb, b.mDa, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        }
    }

    public final void h(Exception exception) {
        x.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.D(this.mFu.intent), Integer.valueOf(m.E(this.mFu.intent)), exception.getMessage(), m.f(exception)});
        FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFu.mEZ;
        d dVar = d.mHC;
        a aVar = new a();
        aVar.mHb = m.a(this.mFu.mFb, b.mDa, m.g(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
    }
}
