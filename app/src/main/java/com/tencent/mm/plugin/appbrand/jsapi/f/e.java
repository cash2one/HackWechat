package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.f;
import com.tencent.mm.plugin.appbrand.j.f.a;
import com.tencent.mm.plugin.appbrand.j.h;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends a {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";

    static /* synthetic */ boolean b(j jVar, String str) {
        f tv = h.aiC().tv(jVar.mAppId);
        if (tv == null || !tv.to(str)) {
            return false;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "upload abort %s", new Object[]{str});
        return true;
    }

    protected final String agB() {
        StringBuilder stringBuilder = new StringBuilder();
        h.aiC();
        return stringBuilder.append(h.aiw()).toString();
    }

    protected final String agC() {
        return "uploadTaskId";
    }

    public final void a(j jVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
        String str2 = jVar.mAppId;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bh.ov(optString)) {
            a(jVar, str, "filePath is null");
            return;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "tempFilePath " + optString);
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str2, optString);
        if (itemByLocalId == null) {
            a(jVar, str, "fail:file doesn't exist");
            return;
        }
        final String str3 = itemByLocalId.hhZ;
        String str4 = itemByLocalId.mimeType;
        x.i("MicroMsg.JsApiCreateUploadTask", "filePath(%s)", new Object[]{str3});
        final j jVar2 = jVar;
        final String str5 = str;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ e joD;

            public final void sD(String str) {
                if (!e.b(jVar2, str5)) {
                    e.a(jVar2, str5, str);
                }
            }

            public final void c(int i, String str, int i2) {
                if (i == 0) {
                    x.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", new Object[]{str3, str, Integer.valueOf(i)});
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    hashMap.put("uploadTaskId", str5);
                    hashMap.put("state", "success");
                    String jSONObject = new JSONObject(hashMap).toString();
                    com.tencent.mm.plugin.appbrand.jsapi.f a = new a().a(jVar2);
                    a.mData = jSONObject;
                    a.afs();
                } else if (!e.b(jVar2, str5)) {
                    x.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", new Object[]{str3, str, Integer.valueOf(i)});
                    e.a(jVar2, str5, str);
                }
            }

            public final void g(int i, long j, long j2) {
                Map hashMap = new HashMap();
                hashMap.put("uploadTaskId", str5);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesSent", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToSend", Long.valueOf(j2));
                String jSONObject = new JSONObject(hashMap).toString();
                com.tencent.mm.plugin.appbrand.jsapi.f a = new a().a(jVar2);
                a.mData = jSONObject;
                a.afs();
            }
        };
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        com.tencent.mm.plugin.appbrand.config.a aVar = jVar.irP.iqy;
        Map a = i.a(jSONObject, appBrandSysConfig);
        String optString2 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString2)) {
            x.i("MicroMsg.JsApiCreateUploadTask", "url is null");
            a(jVar, str, "url is null or nil");
            return;
        }
        boolean a2 = i.a(appBrandSysConfig, jSONObject.optBoolean("__skipDomainCheck__", false));
        if (!a2 || i.a(appBrandSysConfig.iOC, optString2)) {
            f fVar;
            String name;
            if (appBrandSysConfig.iOr <= 0) {
                x.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
            }
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = i.a(appBrandSysConfig, aVar, 2);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            if (h.aiC().tv(str2) == null) {
                p b = b(jVar);
                optString2 = null;
                if (!(b == null || b.jDS == null)) {
                    optString2 = b.jDS.jFe;
                }
                f fVar2 = new f(str2, optString2, jVar.irP.iqx);
                h aiC = h.aiC();
                if (!aiC.jhY.containsKey(str2)) {
                    aiC.jhY.put(str2, fVar2);
                }
                fVar = fVar2;
            } else {
                fVar = h.aiC().tv(str2);
            }
            if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                name = org.a.a.a.a.getName(optString);
            } else {
                name = "wx-file." + itemByLocalId.iHF;
            }
            if (fVar != null) {
                x.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[]{Boolean.valueOf(a2), Integer.valueOf(optInt)});
                if (a2) {
                    fVar.a(optInt, str4, str3, jSONObject, a, appBrandSysConfig.iOC, anonymousClass1, str, NAME, name);
                    return;
                }
                fVar.a(optInt, str4, str3, jSONObject, a, null, anonymousClass1, str, NAME, name);
                return;
            }
            return;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", new Object[]{optString2});
        a(jVar, str, "url not in domain list");
    }

    private static void a(j jVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        com.tencent.mm.plugin.appbrand.jsapi.f a = new a().a(jVar);
        a.mData = jSONObject;
        a.afs();
    }
}
