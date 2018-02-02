package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class n extends a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String str = jVar.mAppId;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
        if (itemByLocalId == null) {
            jVar.E(i, e("fail:file doesn't exist", null));
            return;
        }
        File file = new File(itemByLocalId.hhZ);
        Map hashMap = new HashMap(3);
        hashMap.put("size", Long.valueOf(file.length()));
        hashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(file.lastModified())));
        jVar.E(i, e("ok", hashMap));
    }
}
