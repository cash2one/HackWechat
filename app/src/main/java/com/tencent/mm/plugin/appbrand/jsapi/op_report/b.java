package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.ReportTask;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        AppBrandStatObject oT = com.tencent.mm.plugin.appbrand.a.oT(jVar.mAppId);
        MainProcessTask reportTask = new ReportTask();
        if (appBrandSysConfig != null) {
            reportTask.appId = appBrandSysConfig.appId;
            reportTask.username = appBrandSysConfig.fnl;
            reportTask.iKd = appBrandSysConfig.iOI.iGK;
            reportTask.fIm = appBrandSysConfig.iOI.iGL;
            reportTask.jhr = v.ZP().iGL;
        }
        if (oT != null) {
            reportTask.scene = oT.scene;
            reportTask.fIs = oT.fIs;
        }
        p b = b(jVar);
        if (b != null) {
            reportTask.fnq = b.getURL();
        }
        reportTask.joU = jSONObject.toString();
        AppBrandMainProcessService.a(reportTask);
        jVar.E(i, e("ok", null));
    }
}
