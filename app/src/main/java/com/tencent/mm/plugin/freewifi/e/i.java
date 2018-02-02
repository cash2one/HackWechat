package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends e implements a {
    protected String fqD;
    private int mFm;
    protected String mFp;
    protected String mFq;
    protected String mFr;
    private Uri mFs;
    private String mFt;
    protected String sign;

    static /* synthetic */ void a(i iVar, String str) {
        iVar.mFm++;
        if (iVar.mFm > 3) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(iVar.intent), Integer.valueOf(m.E(iVar.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = iVar.mEZ;
            FreeWifiFrontPageUI$d freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            a aVar = new a();
            aVar.mHb = m.a(iVar.mFb, b.mDa, 33);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.D(iVar.intent), Integer.valueOf(m.E(iVar.intent)), str});
        if (m.AA(str)) {
            freeWifiFrontPageUI = iVar.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new a();
            aVar.mHb = m.a(iVar.mFb, b.mDa, 34);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a 2 = new 2(iVar);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLn();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 2);
    }

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        this.mFm = 0;
        this.mFt = this.intent.getStringExtra("free_wifi_schema_uri");
        this.mFs = Uri.parse(this.mFt);
        this.appId = this.mFs.getQueryParameter("appId");
        this.mFp = this.mFs.getQueryParameter("shopId");
        this.mFq = this.mFs.getQueryParameter("authUrl");
        this.mFr = this.mFs.getQueryParameter("extend");
        this.fqD = this.mFs.getQueryParameter("timestamp");
        this.sign = this.mFs.getQueryParameter("sign");
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mFs, this.appId, this.mFp, this.mFq, this.mFr, this.fqD, this.sign});
    }

    public final void connect() {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        FreeWifiFrontPageUI$d freeWifiFrontPageUI$d;
        a aVar;
        if (m.AA(this.ssid)) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent))});
            freeWifiFrontPageUI = this.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new a();
            aVar.mHb = m.a(this.mFb, b.mDa, 32);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
        } else if (m.AA(this.mFq)) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent))});
            freeWifiFrontPageUI = this.mEZ;
            freeWifiFrontPageUI$d = FreeWifiFrontPageUI$d.FAIL;
            aVar = new a();
            aVar.mHb = m.a(this.mFb, b.mDa, 32);
            freeWifiFrontPageUI.a(freeWifiFrontPageUI$d, aVar);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.mFq);
            if (this.mFq.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.mFr);
            } else {
                stringBuilder.append("&extend=").append(this.mFr);
            }
            j.aLR().aLz().post(new 1(this, stringBuilder.toString()));
        }
    }

    protected final void aMo() {
        j.aLR().aLz().post(new 3(this));
    }
}
