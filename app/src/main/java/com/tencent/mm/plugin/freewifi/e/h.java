package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends e implements a {
    private String mFl = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int mFm = 0;

    static /* synthetic */ void a(h hVar, String str) {
        hVar.mFm++;
        if (hVar.mFm > 3) {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(hVar.intent), Integer.valueOf(m.E(hVar.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = hVar.mEZ;
            FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            a aVar = new a();
            aVar.mHb = m.a(hVar.mFb, b.mCX, 33);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
            hVar.ag(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.D(hVar.intent), Integer.valueOf(m.E(hVar.intent)), str});
        if (m.AA(str)) {
            freeWifiFrontPageUI = hVar.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new a();
            aVar.mHb = m.a(hVar.mFb, b.mCX, 34);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
            hVar.ag(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a 2 = new 2(hVar);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLn();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 2);
    }

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mFl});
    }

    public final void connect() {
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mFl});
        final String str = this.mFl;
        j.aLR().aLz().post(new Runnable(this) {
            final /* synthetic */ h mFn;

            public final void run() {
                x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.D(this.mFn.intent), Integer.valueOf(m.E(this.mFn.intent)), str});
                com.tencent.mm.plugin.freewifi.a.a.aLn();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new 1(this));
            }
        });
    }

    private void ag(int i, String str) {
        k.a aLe = k.aLe();
        aLe.ssid = this.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.ProtocolThreeOne");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.ProtocolThreeOne");
        aLe.fpz = this.fpz;
        aLe.mCt = this.appId;
        aLe.mCu = m.D(this.intent);
        aLe.mCv = 31;
        aLe.mCw = b.mCX.mDi;
        aLe.mCx = b.mCX.name;
        aLe.result = i;
        aLe.kZo = str;
        aLe.fCR = m.G(this.intent);
        aLe.aLg().b(this.intent, i != 0).aLf();
    }
}
