package com.tencent.mm.plugin.freewifi.ui;

import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.b.2;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements e {
    final /* synthetic */ b mGN;

    b$1(b bVar) {
        this.mGN = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.fpz = this.mGN.fpz;
        aLe.mCu = m.D(this.mGN.intent);
        aLe.mCw = b.mCF.mDi;
        aLe.mCx = b.mCF.name;
        aLe.mCv = m.F(this.mGN.intent);
        aLe.fCR = this.mGN.fCR;
        aLe.result = i2;
        aLe.kZo = str;
        aLe.aLg().b(this.mGN.intent, i2 != 0).aLf();
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.D(this.mGN.intent), Integer.valueOf(m.E(this.mGN.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            b bVar = this.mGN;
            if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) kVar;
                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar.aLY());
                wi aLZ = aVar.aLZ();
                if (aLZ != null) {
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), aLZ.nkv, aLZ.kub, aLZ.ksU, aLZ.nfZ, aLZ.wgH, aLZ.wgI, aLZ.vLX, aLZ.vWi, Integer.valueOf(aLZ.vEa)});
                    bVar.intent.putExtra("free_wifi_appid", aLZ.nkv);
                    bVar.intent.putExtra("free_wifi_head_img_url", aLZ.nfZ);
                    bVar.intent.putExtra("free_wifi_welcome_msg", aLZ.wgH);
                    bVar.intent.putExtra("free_wifi_privacy_url", aLZ.wgI);
                    bVar.intent.putExtra("free_wifi_app_nickname", aLZ.kub);
                    bVar.intent.putExtra("free_wifi_welcome_sub_title", aLZ.nfL);
                }
                if (bVar.fCR != 2) {
                    bVar.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                }
                azp aLX = aVar.aLX();
                if (aLX == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                    bVar.activity.finish();
                    aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                    aLe.fpz = bVar.fpz;
                    aLe.mCu = m.D(bVar.intent);
                    aLe.mCw = b.mCG.mDi;
                    aLe.mCx = b.mCG.name;
                    aLe.mCv = m.F(bVar.intent);
                    aLe.fCR = bVar.fCR;
                    aLe.result = -1;
                    aLe.kZo = "qstrInfo is null.";
                    aLe.aLg().b(bVar.intent, true).aLf();
                    return;
                } else if (m.AA(aLX.lOe)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                    bVar.activity.finish();
                    aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                    aLe.fpz = bVar.fpz;
                    aLe.mCu = m.D(bVar.intent);
                    aLe.mCw = b.mCG.mDi;
                    aLe.mCx = b.mCG.name;
                    aLe.mCv = m.F(bVar.intent);
                    aLe.fCR = bVar.fCR;
                    aLe.result = -1;
                    aLe.kZo = "qstrInfo.Ssid is empty.";
                    aLe.aLg().b(bVar.intent, true).aLf();
                    return;
                } else {
                    bVar.intent.putExtra("free_wifi_ssid", aLX.lOe);
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), Integer.valueOf(aLX.wGR), aLX.lOe, aLX.wcq});
                    String aMa = aVar.aMa();
                    String aMb = aVar.aMb();
                    bVar.intent.putExtra("free_wifi_openid", aMa);
                    bVar.intent.putExtra("free_wifi_tid", aMb);
                    bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", aLZ.vLX);
                    bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", aLZ.vWi);
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), aMa, aMb});
                    bVar.intent.putExtra("free_wifi_protocol_type", aLX.wGR);
                    if (aLX.wGR == 10) {
                        if (bh.ov(aLX.lOe) || bh.ov(aLX.wcq)) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                            bVar.activity.finish();
                            return;
                        }
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                        bVar.intent.putExtra("free_wifi_auth_type", 2);
                        bVar.intent.putExtra("free_wifi_passowrd", aLX.wcq);
                        bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                        return;
                    } else if (aLX.wGR == 11) {
                        if (bh.ov(aLX.lOe) || bh.ov(aLX.wcq)) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                            bVar.activity.finish();
                            return;
                        }
                        bVar.intent.putExtra("free_wifi_auth_type", 2);
                        bVar.intent.putExtra("free_wifi_passowrd", aLX.wcq);
                        bVar.intent.setClass(bVar.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                        return;
                    } else if (aLX.wGR == 12) {
                        bVar.intent.putExtra("free_wifi_auth_type", 1);
                        bVar.intent.setClass(bVar.activity, FreeWifiActivateAuthStateUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                        return;
                    } else if (aLX.wGR == 31) {
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent))});
                        String stringExtra = bVar.intent.getStringExtra("free_wifi_schema_ticket");
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), stringExtra});
                        if (bh.ov(stringExtra)) {
                            bVar.activity.finish();
                            aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                            aLe.fpz = bVar.fpz;
                            aLe.mCu = m.D(bVar.intent);
                            aLe.mCw = b.mCG.mDi;
                            aLe.mCx = b.mCG.name;
                            aLe.fCR = bVar.fCR;
                            aLe.mCv = m.F(bVar.intent);
                            aLe.result = -1;
                            aLe.kZo = "31 ticket is empty.";
                            aLe.aLg().b(bVar.intent, true).aLf();
                            return;
                        }
                        String str2 = aLX.lOe;
                        String str3 = aLZ.vLX;
                        String str4 = aLZ.vWi;
                        WifiInfo aLE = d.aLE();
                        if (aLE == null) {
                            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent))});
                            bVar.AT(bVar.activity.getString(R.l.ejI));
                            aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                            aLe.fpz = bVar.fpz;
                            aLe.mCu = m.D(bVar.intent);
                            aLe.mCw = b.mCG.mDi;
                            aLe.mCx = b.mCG.name;
                            aLe.fCR = bVar.fCR;
                            aLe.mCv = m.F(bVar.intent);
                            aLe.result = -1;
                            aLe.kZo = "wifiInfo is empty.";
                            aLe.aLg().b(bVar.intent, true).aLf();
                            return;
                        }
                        boolean AJ = d.AJ(str2);
                        String str5 = "MicroMsg.FreeWifi.FreeWifiNetCheckUI";
                        String str6 = "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. wifiInfo=%s, is_current_connected_ssid_equals_target_ssid=%b";
                        Object[] objArr = new Object[4];
                        objArr[0] = m.D(bVar.intent);
                        objArr[1] = Integer.valueOf(m.E(bVar.intent));
                        objArr[2] = aLE == null ? "null" : aLE.toString();
                        objArr[3] = Boolean.valueOf(AJ);
                        x.i(str5, str6, objArr);
                        str5 = m.AB(aLE.getSSID());
                        str6 = aLE.getBSSID();
                        String macAddress = aLE.getMacAddress();
                        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                            macAddress = m.aLj();
                        }
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), bVar.fpz, str5, str6, macAddress, stringExtra});
                        aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                        aLe.fpz = bVar.fpz;
                        aLe.mCu = m.D(bVar.intent);
                        aLe.mCw = b.mCG.mDi;
                        aLe.mCx = b.mCG.name;
                        aLe.fCR = bVar.fCR;
                        aLe.mCv = m.F(bVar.intent);
                        aLe.result = 0;
                        aLe.kZo = "";
                        aLe.aLg().b(bVar.intent, true).aLf();
                        aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                        aLe.ssid = bVar.intent.getStringExtra("free_wifi_ssid");
                        aLe.fpz = bVar.fpz;
                        aLe.mCt = bVar.intent.getStringExtra("free_wifi_appid");
                        aLe.mCu = m.D(bVar.intent);
                        aLe.mCv = m.F(bVar.intent);
                        aLe.mCw = b.mCQ.mDi;
                        aLe.mCx = b.mCQ.name;
                        aLe.fCR = m.G(bVar.intent);
                        aLe.mCv = m.F(bVar.intent);
                        aLe.aLg().b(bVar.intent, false).aLf();
                        new i(bVar.fpz, str5, str6, macAddress, stringExtra, m.D(bVar.intent)).v(bVar.activity).b(new 2(bVar, aMa, aMb, str3, str4));
                        return;
                    } else if (aLX.wGR == 32) {
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent))});
                        bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                        return;
                    } else if (aLX.wGR == 1) {
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                        bVar.intent.putExtra("free_wifi_auth_type", 1);
                        bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                        return;
                    } else {
                        bVar.activity.finish();
                        bVar.AT(bVar.activity.getString(R.l.ejK));
                        return;
                    }
                }
            }
            bVar.AT(bVar.activity.getString(R.l.ejI));
        } else if (m.cA(i, i2) && !m.AA(str)) {
            this.mGN.AT(str + "(" + m.a(m.F(this.mGN.intent), b.mCF, i2) + ")");
        } else if (i2 == -30031) {
            this.mGN.AT(this.mGN.activity.getString(R.l.ejJ));
        } else {
            this.mGN.AT(this.mGN.activity.getString(R.l.ejI) + "(" + String.format("%02d", new Object[]{Integer.valueOf(m.F(this.mGN.intent))}) + b.mCF.mDi + Math.abs(i2) + ")");
        }
    }
}
