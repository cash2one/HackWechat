package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        super.a(jVar, jSONObject, i);
        Map hashMap;
        if (!d.jvt) {
            x.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            jVar.E(i, e("fail:not invoke startWifi", hashMap));
        } else if (jSONObject == null || !jSONObject.has("SSID")) {
            x.e("MicroMsg.JsApiConenctWifi", "params is invalid");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            jVar.E(i, e("fail:invalid data", hashMap));
        } else {
            Context context = jVar.getContext();
            if (context == null) {
                x.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                jVar.E(i, e("fail:context is null", hashMap));
                return;
            }
            d.bY(context);
            if (c.isWifiEnabled()) {
                final b dVar = new com.tencent.mm.plugin.appbrand.widget.c.d(context);
                dVar.setCancelable(false);
                ag.y(new Runnable(this) {
                    final /* synthetic */ a jvr;

                    public final void run() {
                        jVar.irP.a(dVar);
                    }
                });
                d.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a(this) {
                    final /* synthetic */ a jvr;

                    public final void sU(String str) {
                        d.a(null);
                        ag.y(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 jvs;

                            {
                                this.jvs = r1;
                            }

                            public final void run() {
                                if (dVar != null) {
                                    dVar.dismiss();
                                }
                            }
                        });
                        if (str.equals("ok")) {
                            com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b ahI = d.ahI();
                            x.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[]{ahI});
                            Map hashMap;
                            if (ahI == null) {
                                x.e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(0));
                                jVar.E(i, this.jvr.e("ok:can't gain current wifi may be not open GPS", hashMap));
                                return;
                            }
                            try {
                                Map hashMap2 = new HashMap();
                                hashMap2.put("wifi", ahI.sN());
                                hashMap2.put("errCode", Integer.valueOf(0));
                                jVar.E(i, this.jvr.e("ok", hashMap2));
                                return;
                            } catch (Throwable e) {
                                x.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
                                x.printErrStackTrace("MicroMsg.JsApiConenctWifi", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                jVar.E(i, this.jvr.e("fail:parse json err", hashMap));
                                return;
                            }
                        }
                        HashMap hashMap3 = new HashMap();
                        if (str.equals("duplicated request")) {
                            hashMap3.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED));
                        } else if (str.equals("password error")) {
                            hashMap3.put("errCode", Integer.valueOf(12002));
                        } else {
                            hashMap3.put("errCode", Integer.valueOf(12003));
                        }
                        x.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", new Object[]{str});
                        jVar.E(i, this.jvr.e("fail:" + str, hashMap3));
                    }
                });
                com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, new 3(this, jVar));
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("BSSID");
                String optString3 = jSONObject.optString("password");
                if (optString.equals("")) {
                    x.e("MicroMsg.JsApiConenctWifi", "params is invalid");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_PLAY_BEGIN));
                    jVar.E(i, e("fail:invalid data", hashMap));
                    return;
                }
                x.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", new Object[]{optString, optString2});
                d.B(optString, optString2, optString3);
                return;
            }
            x.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            jVar.E(i, e("fail:wifi is disable", hashMap));
        }
    }
}
