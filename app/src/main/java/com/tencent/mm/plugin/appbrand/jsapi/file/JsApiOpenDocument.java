package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public final class JsApiOpenDocument extends a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long jjC = -1;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        long Wp = bh.Wp();
        if (Wp - jjC < 1000) {
            jVar.E(i, e("fail:document viewer already starting", null));
            return;
        }
        jjC = Wp;
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bh.ov(optString)) {
            jVar.E(i, e("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(jVar.mAppId, optString);
        if (itemByLocalId == null) {
            jVar.E(i, e("fail:file doesn't exist", null));
            return;
        }
        ProcessRequest openRequest = new OpenRequest();
        openRequest.filePath = itemByLocalId.hhZ;
        openRequest.iHF = s.Sd(itemByLocalId.mimeType);
        optString = jSONObject.optString("fileType");
        if (!bh.ov(optString)) {
            openRequest.iHF = optString;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, openRequest, new 1(this, jVar, i));
    }
}
