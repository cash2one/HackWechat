package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.a$a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends e implements a {
    String fqD = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    private a mFg;
    private int mFm = 0;
    String mFx = this.intent.getStringExtra("free_wifi_tid");
    String openId = this.intent.getStringExtra("free_wifi_openid");
    String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");

    static /* synthetic */ void a(j jVar) {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.D(jVar.intent), Integer.valueOf(m.E(jVar.intent)), jVar.ssid});
        jVar.mFg.a(new a$a(jVar) {
            final /* synthetic */ j mFy;

            {
                this.mFy = r1;
            }

            public final void onSuccess() {
                k.a aLe = k.aLe();
                aLe.ssid = this.mFy.ssid;
                aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32");
                aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32");
                aLe.fpz = this.mFy.fpz;
                aLe.mCt = this.mFy.appId;
                aLe.mCu = m.D(this.mFy.intent);
                aLe.mCv = m.F(this.mFy.intent);
                aLe.mCw = b.mCH.mDi;
                aLe.mCx = b.mCH.name;
                aLe.result = 0;
                aLe.fCR = m.G(this.mFy.intent);
                aLe.aLg().aLf();
                String aLb = h.b.aLc().aLb();
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.D(this.mFy.intent), Integer.valueOf(m.E(this.mFy.intent)), this.mFy.ssid, aLb});
                com.tencent.mm.plugin.freewifi.a.a.a 1 = new 1(this, aLb);
                com.tencent.mm.plugin.freewifi.a.a.aLn();
                com.tencent.mm.plugin.freewifi.a.a.a(aLb, 1);
            }

            public final void pQ(int i) {
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.D(this.mFy.intent), Integer.valueOf(m.E(this.mFy.intent)), this.mFy.ssid, Integer.valueOf(i)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFy.mEZ;
                FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.mHb = m.a(this.mFy.mFb, b.mCH, i);
                freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
                k.a aLe = k.aLe();
                aLe.ssid = this.mFy.ssid;
                aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32");
                aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32");
                aLe.fpz = this.mFy.fpz;
                aLe.mCt = this.mFy.appId;
                aLe.mCu = m.D(this.mFy.intent);
                aLe.mCv = m.F(this.mFy.intent);
                aLe.mCx = b.mCH.name;
                aLe.mCw = b.mCH.mDi;
                aLe.result = i;
                aLe.fCR = m.G(this.mFy.intent);
                aLe.aLg().aLf();
            }
        });
    }

    static /* synthetic */ void a(j jVar, String str) {
        jVar.mFm++;
        if (jVar.mFm > 3) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(jVar.intent), Integer.valueOf(m.E(jVar.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = jVar.mEZ;
            FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.mHb = m.a(jVar.mFb, b.mCY, 33);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
            jVar.ah(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.D(jVar.intent), Integer.valueOf(m.E(jVar.intent)), str});
        if (m.AA(str)) {
            freeWifiFrontPageUI = jVar.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.mHb = m.a(jVar.mFb, b.mCY, 34);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
            jVar.ah(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a 4 = new 4(jVar);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLn();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 4);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 4);
    }

    static /* synthetic */ void b(j jVar, int i, String str) {
        k.a aLe = k.aLe();
        aLe.ssid = jVar.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32");
        aLe.fpz = jVar.fpz;
        aLe.mCt = jVar.appId;
        aLe.mCu = m.D(jVar.intent);
        aLe.mCv = 32;
        aLe.mCw = b.mCY.mDi;
        aLe.mCx = b.mCY.name;
        aLe.result = i;
        aLe.kZo = str;
        aLe.fCR = m.G(jVar.intent);
        aLe.aLg().aLf();
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.openId, this.mFx, this.fqD, this.sign});
    }

    public final void connect() {
        this.mFg = new a(this.ssid, this.mEZ);
        com.tencent.mm.plugin.freewifi.model.j.aLR().aLz().post(new Runnable(this) {
            final /* synthetic */ j mFy;

            {
                this.mFy = r1;
            }

            public final void run() {
                j.a(this.mFy);
            }
        });
    }

    private void ah(int i, String str) {
        k.a aLe = k.aLe();
        aLe.ssid = this.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32");
        aLe.fpz = this.fpz;
        aLe.mCt = this.appId;
        aLe.mCu = m.D(this.intent);
        aLe.mCv = 32;
        aLe.mCw = b.mCY.mDi;
        aLe.mCx = b.mCY.name;
        aLe.result = i;
        aLe.kZo = str;
        aLe.fCR = m.G(this.intent);
        aLe.aLg().aLf();
    }
}
