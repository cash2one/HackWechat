package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 318;
    public static final String NAME = "getConnectedWifi";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        Map hashMap;
        if (d.jvt) {
            Context context = jVar.getContext();
            if (context == null) {
                x.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                jVar.E(i, e("fail:context is null", hashMap));
                return;
            }
            d.bY(context);
            if (c.isWifiEnabled()) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b ahI = d.ahI();
                if (ahI != null) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        x.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        jVar.E(i, e("fail:connectivityManager is null", hashMap));
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        x.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        jVar.E(i, e("fail:netInfo is null", hashMap));
                        return;
                    } else if (activeNetworkInfo.getDetailedState() != DetailedState.CONNECTED) {
                        x.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[]{activeNetworkInfo.getDetailedState()});
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        jVar.E(i, e("fail:detailState is not connected", hashMap));
                        return;
                    } else {
                        x.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[]{ahI});
                        try {
                            hashMap = new HashMap();
                            hashMap.put("wifi", ahI.sN());
                            hashMap.put("errCode", Integer.valueOf(0));
                            jVar.E(i, e("ok", hashMap));
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", e, "", new Object[0]);
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(12010));
                            jVar.E(i, e("fail:parse json err", hashMap));
                            return;
                        }
                    }
                } else if (VERSION.SDK_INT < 23 || com.tencent.mm.plugin.appbrand.ui.j.zj() || ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps")) {
                    x.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                    if (com.tencent.mm.pluginsdk.g.a.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                        x.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        jVar.E(i, e("fail:currentWifi is null", hashMap));
                        return;
                    }
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT));
                    jVar.E(i, e("fail:may be not obtain GPS Perrmission", hashMap));
                    x.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
                    return;
                } else {
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(12006));
                    jVar.E(i, e("fail:may be not open GPS", hashMap));
                    x.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
                    return;
                }
            }
            x.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            jVar.E(i, e("fail:wifi is disable", hashMap));
            return;
        }
        x.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        jVar.E(i, e("fail:not invoke startWifi", hashMap));
    }
}
