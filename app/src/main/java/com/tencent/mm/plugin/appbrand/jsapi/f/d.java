package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.b.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.j.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
    public static final int CTRL_INDEX = 346;
    public static final String NAME = "createSocketTask";

    protected final String agB() {
        StringBuilder stringBuilder = new StringBuilder();
        k.aiE();
        return stringBuilder.append(k.aiw()).toString();
    }

    protected final String agC() {
        return "socketTaskId";
    }

    public final void a(final j jVar, JSONObject jSONObject, final String str) {
        com.tencent.mm.plugin.appbrand.j.j tB = k.aiE().tB(jVar.mAppId);
        if (tB == null) {
            p b = b(jVar);
            String str2 = null;
            if (!(b == null || b.jDS == null)) {
                str2 = b.jDS.jFe;
            }
            com.tencent.mm.plugin.appbrand.j.j jVar2 = new com.tencent.mm.plugin.appbrand.j.j(jVar.mAppId, str2, jVar.irP.iqx);
            k aiE = k.aiE();
            String str3 = jVar.mAppId;
            if (!aiE.jhY.containsKey(str3)) {
                aiE.jhY.put(str3, jVar2);
            }
            tB = jVar2;
        }
        final a 1 = new 1(this, tB, str, jVar);
        com.tencent.mm.plugin.appbrand.j.j.a anonymousClass2 = new com.tencent.mm.plugin.appbrand.j.j.a(this) {
            boolean joA = false;
            final /* synthetic */ d joz;

            public final void a(h hVar) {
                jVar.irP.iqO.a(1);
                Map hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "open");
                hashMap.put("header", d.c(hVar));
                String jSONObject = new JSONObject(hashMap).toString();
                f a = new a().a(jVar);
                a.mData = jSONObject;
                a.afs();
            }

            public final void re(String str) {
                if (this.joA) {
                    x.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
                    return;
                }
                this.joA = true;
                Map hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "error");
                hashMap.put("errMsg", str);
                String jSONObject = new JSONObject(hashMap).toString();
                f a = new a().a(jVar);
                a.mData = jSONObject;
                a.afs();
            }

            public final void rf(String str) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, c.uF(str));
                hashMap.put("isBuffer", Boolean.valueOf(false));
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "message");
                String jSONObject = new JSONObject(hashMap).toString();
                f a = new a().a(jVar);
                a.mData = jSONObject;
                a.afs();
            }

            public final void e(ByteBuffer byteBuffer) {
                Map hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, byteBuffer);
                hashMap.put("isBuffer", Boolean.valueOf(true));
                hashMap.put("state", "message");
                if (l.a(jVar, hashMap, new a())) {
                    String jSONObject = new JSONObject(hashMap).toString();
                    f a = new a().a(jVar);
                    a.mData = jSONObject;
                    a.afs();
                }
            }

            public final void C(int i, String str) {
                Object obj;
                b bVar = jVar.irP.iqO;
                a aVar = 1;
                if (!(aVar == null || com.tencent.mm.plugin.appbrand.b.a.iGT == bVar.iGV.aas())) {
                    synchronized (bVar.iGW) {
                        bVar.iGW.remove(aVar);
                    }
                }
                Map hashMap = new HashMap();
                switch (AnonymousClass3.iGZ[jVar.irP.iqO.iGV.aas().ordinal()]) {
                    case 1:
                    case 2:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    hashMap.put("reason", "interrupted");
                } else if (!bh.ov(str)) {
                    hashMap.put("reason", str);
                }
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, Integer.valueOf(i));
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "close");
                String jSONObject = new JSONObject(hashMap).toString();
                f a = new a().a(jVar);
                a.mData = jSONObject;
                a.afs();
            }

            public final void rg(String str) {
                d.a(jVar, str, str);
            }
        };
        com.tencent.mm.plugin.appbrand.config.a aVar = jVar.irP.iqy;
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            x.i("MicroMsg.JsApiCreateSocketTask", "url is null");
            a(jVar, str, "url is null");
            return;
        }
        x.i("MicroMsg.JsApiCreateSocketTask", "url is " + optString);
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        Map a = i.a(jSONObject, appBrandSysConfig);
        if (!i.a(appBrandSysConfig, jSONObject.optBoolean("__skipDomainCheck__", false)) || i.a(appBrandSysConfig.iOB, optString, appBrandSysConfig.iOv)) {
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = i.a(appBrandSysConfig, aVar, 1);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            tB.a(str, optInt, jSONObject, a, anonymousClass2);
            x.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s ,appid: %s", new Object[]{optString, appBrandSysConfig.appId});
            return;
        }
        x.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[]{optString});
        a(jVar, str, "url not in domain list");
    }

    private static JSONObject c(h hVar) {
        JSONObject jSONObject = new JSONObject();
        Iterator amb = hVar.amb();
        while (amb.hasNext()) {
            try {
                String str = (String) amb.next();
                jSONObject.put(str, hVar.uM(str));
            } catch (JSONException e) {
                x.w("MicroMsg.JsApiCreateSocketTask", "JSONException " + e);
            }
        }
        return jSONObject;
    }

    private static void a(j jVar, String str, String str2) {
        Object obj;
        if (bh.ov(str2)) {
            obj = "fail";
        } else {
            obj = "fail:" + str2;
        }
        Map hashMap = new HashMap();
        hashMap.put("socketTaskId", str);
        hashMap.put("state", "error");
        hashMap.put("errMsg", obj);
        String jSONObject = new JSONObject(hashMap).toString();
        f a = new a().a(jVar);
        a.mData = jSONObject;
        a.afs();
        x.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[]{jSONObject});
    }
}
