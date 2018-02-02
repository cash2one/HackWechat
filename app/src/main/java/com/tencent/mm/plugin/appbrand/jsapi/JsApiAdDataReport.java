package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class JsApiAdDataReport extends a {
    public static final int CTRL_INDEX = 435;
    public static final String NAME = "adDataReport";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new AdDataReportTask(this, pVar, i, jSONObject));
    }
}
