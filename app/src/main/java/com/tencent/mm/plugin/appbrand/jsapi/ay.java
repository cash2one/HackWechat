package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ay extends a {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(pVar.mAppId);
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.jhm = System.currentTimeMillis();
        reportSubmitFormTask.fCp = pVar.aeO();
        AppBrandMainProcessService.a(reportSubmitFormTask);
        Map hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.jhm);
        i pm = i.pm(pVar.mAppId);
        if (pm != null) {
            pm.irI = reportSubmitFormTask.jhm;
        }
        pVar.E(i, e("ok", hashMap));
    }
}
