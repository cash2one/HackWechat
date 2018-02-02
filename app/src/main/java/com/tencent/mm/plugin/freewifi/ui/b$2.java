package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements e {
    final /* synthetic */ b mGN;
    final /* synthetic */ String mGO;
    final /* synthetic */ String mGP;
    final /* synthetic */ String mGQ;
    final /* synthetic */ String mGR;

    b$2(b bVar, String str, String str2, String str3, String str4) {
        this.mGN = bVar;
        this.mGO = str;
        this.mGP = str2;
        this.mGQ = str3;
        this.mGR = str4;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.D(this.mGN.intent), Integer.valueOf(m.E(this.mGN.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        a aLe;
        if (i == 0 && i2 == 0) {
            aLe = com.tencent.mm.plugin.freewifi.k.aLe();
            aLe.fpz = this.mGN.fpz;
            aLe.mCu = m.D(this.mGN.intent);
            aLe.mCw = b.mCR.mDi;
            aLe.mCx = b.mCR.name;
            aLe.fCR = this.mGN.fCR;
            aLe.result = i2;
            aLe.kZo = str;
            aLe.aLg().b(this.mGN.intent, false).aLf();
            i iVar = (i) kVar;
            String aMg = iVar.aMg();
            if (m.AA(aMg)) {
                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", new Object[]{m.D(this.mGN.intent), Integer.valueOf(m.E(this.mGN.intent))});
                this.mGN.AT(this.mGN.activity.getString(R.l.ejI));
                aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                aLe.fpz = this.mGN.fpz;
                aLe.mCu = m.D(this.mGN.intent);
                aLe.mCw = b.mCS.mDi;
                aLe.mCx = b.mCS.name;
                aLe.fCR = this.mGN.fCR;
                aLe.mCv = m.F(this.mGN.intent);
                aLe.result = -1;
                aLe.kZo = "31 auth url is empty.";
                aLe.aLg().b(this.mGN.intent, true).aLf();
                return;
            }
            String AC = m.AC(iVar.aMh());
            String AC2 = m.AC(this.mGO);
            String AC3 = m.AC(this.mGP);
            StringBuilder stringBuilder = new StringBuilder(aMg);
            if (aMg.indexOf("?") != -1) {
                stringBuilder.append("&extend=").append(AC);
            } else {
                stringBuilder.append("?extend=").append(AC);
            }
            stringBuilder.append("&openId=").append(AC2).append("&tid=").append(AC3).append("&timestamp=").append(m.AC(this.mGQ)).append("&sign=").append(m.AC(this.mGR));
            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", new Object[]{m.D(this.mGN.intent), Integer.valueOf(m.E(this.mGN.intent)), stringBuilder.toString()});
            this.mGN.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
            this.mGN.intent.setClass(this.mGN.activity, FreeWifiFrontPageUI.class);
            this.mGN.activity.startActivity(this.mGN.intent);
            this.mGN.activity.finish();
            this.mGN.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
            aLe = com.tencent.mm.plugin.freewifi.k.aLe();
            aLe.fpz = this.mGN.fpz;
            aLe.mCu = m.D(this.mGN.intent);
            aLe.mCw = b.mCS.mDi;
            aLe.mCx = b.mCS.name;
            aLe.fCR = this.mGN.fCR;
            aLe.mCv = m.F(this.mGN.intent);
            aLe.result = 0;
            aLe.kZo = "";
            aLe.aLg().b(this.mGN.intent, true).aLf();
            return;
        }
        aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.fpz = this.mGN.fpz;
        aLe.mCu = m.D(this.mGN.intent);
        aLe.mCw = b.mCR.mDi;
        aLe.mCx = b.mCR.name;
        aLe.fCR = this.mGN.fCR;
        aLe.mCv = m.F(this.mGN.intent);
        aLe.result = i2;
        aLe.kZo = str;
        aLe.aLg().b(this.mGN.intent, true).aLf();
        if (m.cA(i, i2) && !m.AA(str)) {
            this.mGN.AT(str + "(" + m.a(m.F(this.mGN.intent), b.mCR, i2) + ")");
        } else if (m.AA(str)) {
            this.mGN.AT(this.mGN.activity.getString(R.l.ejI));
        } else {
            this.mGN.AT(str);
        }
    }
}
