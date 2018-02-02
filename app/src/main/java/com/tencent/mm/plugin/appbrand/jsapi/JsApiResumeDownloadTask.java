package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask extends a {
    public static final int CTRL_INDEX = 444;
    public static final String NAME = "resumeDownloadTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new ResumeDownloadTask(this, jVar, i, jSONObject));
    }
}
