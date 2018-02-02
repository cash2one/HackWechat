package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 317;
    public static final String NAME = "getWifiList";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Map hashMap;
        if (d.jvt) {
            Context context = jVar.getContext();
            if (context == null) {
                x.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                jVar.E(i, e("fail:context is null", hashMap));
                return;
            }
            d.bY(context);
            if (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c ahJ = d.ahJ();
                if (ahJ.jey.equals("ok")) {
                    try {
                        x.i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", new Object[]{Integer.valueOf(ahJ.jvD.size())});
                        if (ahJ.jvD.size() == 0) {
                            if (VERSION.SDK_INT < 23 || com.tencent.mm.plugin.appbrand.ui.j.zj() || ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps")) {
                                x.i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                                if (!com.tencent.mm.pluginsdk.g.a.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                                    hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT));
                                    jVar.E(i, e("fail:may be not obtain GPS Perrmission", hashMap));
                                    x.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
                                    return;
                                }
                            }
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(12006));
                            jVar.E(i, e("fail:may be not open GPS", hashMap));
                            x.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
                            return;
                        }
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(0));
                        jVar.E(i, e("ok", hashMap));
                        x.d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", new Object[]{ahJ});
                        a aVar = new a();
                        Map hashMap2 = new HashMap();
                        hashMap2.put("wifiList", ahJ.ahH());
                        aVar.az(jVar.mAppId, 0).v(hashMap2).afs();
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiGetWifiList", e, "", new Object[0]);
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        jVar.E(i, e("fail:parse json err", hashMap));
                        return;
                    }
                }
                x.e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", new Object[]{ahJ.jey});
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                jVar.E(i, e("fail:" + ahJ.jey, hashMap));
                return;
            }
            x.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            jVar.E(i, e("fail:wifi is disable", hashMap));
            return;
        }
        x.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        jVar.E(i, e("fail:not invoke startWifi", hashMap));
    }
}
