package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public final class x extends a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String str = jVar.mAppId;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bh.ov(optString)) {
            str = "fail:invalid data";
        } else {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
            if (itemByLocalId == null || bh.ov(itemByLocalId.hhZ)) {
                str = "fail:file doesn't exist";
            } else {
                b.deleteFile(itemByLocalId.hhZ);
                str = "ok";
            }
        }
        jVar.E(i, e(str, null));
    }
}
