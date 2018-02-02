package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.a;
import com.tencent.mm.plugin.appbrand.j.a.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b extends a {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    static /* synthetic */ boolean a(j jVar, String str) {
        a tq = com.tencent.mm.plugin.appbrand.j.b.aix().tq(jVar.mAppId);
        if (tq == null || !tq.to(str)) {
            return false;
        }
        x.i("MicroMsg.JsApiCreateDownloadTask", "download abort %s", new Object[]{str});
        return true;
    }

    protected final String agB() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.appbrand.j.b.aix();
        return stringBuilder.append(com.tencent.mm.plugin.appbrand.j.b.aiw()).toString();
    }

    protected final String agC() {
        return "downloadTaskId";
    }

    public final void a(j jVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
        a.a 1 = new 1(this, jSONObject.optString(DownloadInfoColumns.FILEPATH), jVar, str, jVar.mAppId);
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        com.tencent.mm.plugin.appbrand.config.a aVar = jVar.irP.iqy;
        Map a = i.a(jSONObject, appBrandSysConfig);
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            x.i("MicroMsg.JsApiCreateDownloadTask", "url is null");
            a(jVar, str, "url is null or nil");
            return;
        }
        boolean a2 = i.a(appBrandSysConfig, jSONObject.optBoolean("__skipDomainCheck__", false));
        if (!a2 || i.a(appBrandSysConfig.iOD, optString)) {
            int i;
            a aVar2;
            if (appBrandSysConfig.iOs <= 0) {
                x.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
            }
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = i.a(appBrandSysConfig, aVar, 3);
            }
            if (optInt > 0) {
                i = optInt;
            } else {
                i = 60000;
            }
            a tq = com.tencent.mm.plugin.appbrand.j.b.aix().tq(jVar.mAppId);
            if (tq == null) {
                p b = b(jVar);
                optString = null;
                if (!(b == null || b.jDS == null)) {
                    optString = b.jDS.jFe;
                }
                a aVar3 = new a(jVar.mAppId, optString, jVar.irP.iqx);
                com.tencent.mm.plugin.appbrand.j.b aix = com.tencent.mm.plugin.appbrand.j.b.aix();
                String str2 = jVar.mAppId;
                if (!aix.jhY.containsKey(str2)) {
                    aix.jhY.put(str2, aVar3);
                }
                aVar2 = aVar3;
            } else {
                aVar2 = tq;
            }
            if (aVar2 != null) {
                int i2;
                x.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[]{Boolean.valueOf(a2), Integer.valueOf(i)});
                if (jVar.irP.Yz()) {
                    i2 = jVar.irP.iqx.iOJ.iNE;
                } else {
                    i2 = jVar.irP.iqx.iOJ.iNr;
                }
                ArrayList arrayList = a2 ? appBrandSysConfig.iOD : null;
                String str3 = NAME;
                String optString2 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                synchronized (aVar2.jBk) {
                    if (aVar2.jBk.size() >= aVar2.jBf) {
                        1.sB("max_connected");
                        x.i("MicroMsg.AppBrandNetworkDownload", "max connected");
                        return;
                    }
                    Runnable bVar = new com.tencent.mm.plugin.appbrand.j.a.b(aVar2.mAppId, optString2, aVar2.jBg + ab.UZ(optString2) + "temp", aVar2.jBi, new AnonymousClass1(aVar2, str, 1));
                    bVar.jCd = a;
                    bVar.gKi = i;
                    bVar.bgH = true;
                    bVar.jBC = arrayList;
                    bVar.jCe = i2;
                    bVar.jBh = aVar2.jBh;
                    bVar.jbo = str;
                    bVar.jBG = str3;
                    synchronized (aVar2.jBk) {
                        aVar2.jBk.add(bVar);
                    }
                    e.post(bVar, "appbrand_download_thread");
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", new Object[]{optString});
        a(jVar, str, "url not in domain list");
    }

    private static void a(j jVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("downloadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        f a = new a().a(jVar);
        a.mData = jSONObject;
        a.afs();
    }
}
