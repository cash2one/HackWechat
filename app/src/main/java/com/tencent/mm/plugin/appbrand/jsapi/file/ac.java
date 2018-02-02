package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jjG = new int[j.values().length];

        static {
            try {
                jjG[j.iIx.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jjG[j.iIw.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jjG[j.iIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jjG[j.iIt.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject, int i) {
        f.a c = c(jVar, jSONObject);
        jVar.E(i, e(c.fnL, c.values));
    }

    static f.a c(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject) {
        String str = jVar.mAppId;
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bh.ov(optString)) {
            x.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            return new f.a("fail", new Object[0]);
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
        boolean z = itemByLocalId != null && e.bO(itemByLocalId.hhZ);
        x.i("MicroMsg.JsApiSaveFile", "get temp obj = %s, fileExists = %b", itemByLocalId, Boolean.valueOf(z));
        if (!z || bh.ov(itemByLocalId.hhZ)) {
            return new f.a("fail tempFilePath file not exist", new Object[0]);
        }
        Map map;
        if (!bh.ov(optString2)) {
            str = a(jVar.irP, itemByLocalId.hhZ, optString2);
            map = null;
            if ("ok".equals(str)) {
                map = new HashMap();
                map.put("savedFilePath", optString2);
            }
            return new f.a(str, new Object[0]).w(map);
        } else if (itemByLocalId.iHG) {
            return new f.a("ok", new Object[0]);
        } else {
            x.i("MicroMsg.JsApiSaveFile", "before markPermanent, quota = %d, occupation = %d, fileLength = %d", Long.valueOf(com.tencent.mm.plugin.appbrand.config.j.qJ(str)), Long.valueOf(AppBrandLocalMediaObjectManager.getStoredFilesOccupation(str)), Long.valueOf(new File(itemByLocalId.hhZ).length()));
            if (AppBrandLocalMediaObjectManager.getStoredFilesOccupation(str) + new File(itemByLocalId.hhZ).length() > com.tencent.mm.plugin.appbrand.config.j.qJ(str)) {
                return new f.a(String.format(Locale.US, "fail:exceed quota %dM", new Object[]{Long.valueOf(r4 / 1048576)}), new Object[0]);
            }
            AppBrandLocalMediaObject markPermanent = AppBrandLocalMediaObjectManager.markPermanent(jVar.mAppId, itemByLocalId);
            optString2 = "MicroMsg.JsApiSaveFile";
            String str2 = "after markPermanent, (obj==null): %b, obj.localId: %s, obj.path: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(markPermanent == null);
            objArr[1] = markPermanent == null ? null : markPermanent.fus;
            objArr[2] = markPermanent == null ? null : markPermanent.hhZ;
            x.i(optString2, str2, objArr);
            if (markPermanent == null || bh.ov(markPermanent.fus) || bh.ov(markPermanent.hhZ)) {
                return new f.a("fail", new Object[0]);
            }
            map = new HashMap(1);
            map.put("savedFilePath", markPermanent.fus);
            return new f.a("ok", new Object[0]).w(map);
        }
    }

    public static String a(com.tencent.mm.plugin.appbrand.e eVar, String str, String str2) {
        j pU = eVar.iqz.pU(str2);
        if (pU == j.iIz || pU == j.iIB) {
            try {
                pU = eVar.iqz.d(str2, new FileInputStream(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiSaveFile", e, "saveToNewFS", new Object[0]);
                return "fail read tempFilePath error";
            }
        }
        switch (AnonymousClass1.jjG[pU.ordinal()]) {
            case 1:
                return String.format("fail permission denied, open \"%s\"", new Object[]{str2});
            case 2:
                return String.format("fail no such file or directory \"%s\"", new Object[]{str2});
            case 3:
                return String.format("fail illegal operation on a directory, open \"%s\"", new Object[]{str2});
            case 4:
                return "ok";
            default:
                return "fail " + pU.name();
        }
    }
}
