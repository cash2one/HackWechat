package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask extends a {
    public static final int CTRL_INDEX = 441;
    public static final String NAME = "queryDownloadTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new QueryDownloadTask(this, jVar, i, jSONObject));
    }
}
