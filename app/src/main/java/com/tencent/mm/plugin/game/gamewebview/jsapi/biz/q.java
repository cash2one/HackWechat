package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends a {
    public static final int CTRL_BYTE = 25;
    public static final String NAME = "getInstallState";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        Context context = dVar.getContext();
        if (context == null) {
            x.i("MicroMsg.GameJsApiGetNetworkType", "context is null");
        } else if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiGetNetworkType", "data is null");
            dVar.E(i, a.e("get_install_state:no_null_data", null));
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray(DownloadInfoColumns.PACKAGENAME);
            Map hashMap;
            if (optJSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                int i2 = 0;
                Object obj = null;
                while (i2 < optJSONArray.length()) {
                    try {
                        String optString = optJSONArray.optString(i2);
                        PackageInfo packageInfo = p.getPackageInfo(context, optString);
                        int i3 = packageInfo == null ? 0 : packageInfo.versionCode;
                        String str = packageInfo == null ? "null" : packageInfo.versionName;
                        x.i("MicroMsg.GameJsApiGetNetworkType", "getInstallState, packageName = " + optString + ", version = " + i3 + ", versionName = " + str);
                        if (obj == null && i3 > 0) {
                            obj = 1;
                        }
                        jSONObject2.put(optString, i3);
                        jSONObject3.put(optString, str);
                        i2++;
                    } catch (Exception e) {
                    }
                }
                hashMap = new HashMap();
                hashMap.put("result", jSONObject2.toString());
                hashMap.put("versionName", jSONObject3.toString());
                if (obj != null) {
                    dVar.E(i, e("get_install_state:yes", hashMap));
                    return;
                } else {
                    dVar.E(i, a.e("get_install_state:no", null));
                    return;
                }
            }
            String optString2 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            if (bh.ov(optString2)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "packageName is null or nil");
                dVar.E(i, a.e("get_install_state:no_null_packageName", null));
                return;
            }
            PackageInfo packageInfo2 = p.getPackageInfo(context, optString2);
            int i4 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
            String str2 = packageInfo2 == null ? "null" : packageInfo2.versionName;
            x.i("MicroMsg.GameJsApiGetNetworkType", "doGetInstallState, packageName = " + optString2 + ", version = " + i4 + ", versionName = " + str2);
            if (packageInfo2 == null) {
                dVar.E(i, a.e("get_install_state:no", null));
                return;
            }
            hashMap = new HashMap();
            hashMap.put("versionName", str2);
            dVar.E(i, e("get_install_state:yes_" + str2, hashMap));
        }
    }
}
