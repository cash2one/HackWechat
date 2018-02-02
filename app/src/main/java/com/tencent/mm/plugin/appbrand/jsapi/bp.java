package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

final class bp extends a {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> jep = new SparseArray();

    bp() {
        jep.put("firstRenderTime".hashCode(), Integer.valueOf(301));
        jep.put("reRenderTime".hashCode(), Integer.valueOf(HardCoderJNI.SCENE_QUIT_CHATTING));
        jep.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(e.CTRL_INDEX));
        jep.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(ap.CTRL_INDEX));
        jep.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(TencentLocation.ERROR_UNKNOWN));
        jep.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
        jep.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(au.CTRL_INDEX));
        jep.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(JsApiPrivateAddContact.CTRL_INDEX));
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.tT(cVar.getAppId()) || optJSONArray == null) {
            cVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString(DownloadSettingTable$Columns.VALUE);
                if (!bh.ov(optString)) {
                    Integer num = (Integer) jep.get(optString.hashCode());
                    if (num != null) {
                        AppBrandPerformanceManager.n(cVar.getAppId(), num.intValue(), optString2);
                    } else {
                        AppBrandPerformanceManager.D(cVar.getAppId(), optString, optString2);
                    }
                }
            }
        }
        cVar.E(i, e("ok", null));
    }
}
