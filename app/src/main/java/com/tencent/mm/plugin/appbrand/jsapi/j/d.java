package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            a(jVar.irP, null, jSONObject);
            jVar.E(i, e("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", jVar.mAppId, e);
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        try {
            a(pVar.irP, pVar, jSONObject);
            pVar.E(i, e("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiReportRealtimeAction", "report by page(%s), e = %s", pVar.mAppId, e);
        }
    }

    private static void a(e eVar, p pVar, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.report.a.e.a h;
        int i;
        String optString = jSONObject.optString("actionData");
        cba com_tencent_mm_protocal_c_cba = new cba();
        com_tencent_mm_protocal_c_cba.ktN = 2;
        com_tencent_mm_protocal_c_cba.ngo = eVar.mAppId;
        com_tencent_mm_protocal_c_cba.pQj = 0;
        com_tencent_mm_protocal_c_cba.lOD = (int) bh.Wo();
        com_tencent_mm_protocal_c_cba.pQk = 0;
        com_tencent_mm_protocal_c_cba.xaj = optString;
        com_tencent_mm_protocal_c_cba.xak = eVar.iqx.iOI.iGK + 1;
        com_tencent_mm_protocal_c_cba.xam = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
        com_tencent_mm_protocal_c_cba.xal = h.e(eVar).irG;
        AppBrandStatObject appBrandStatObject = eVar.iqH;
        com_tencent_mm_protocal_c_cba.tlN = appBrandStatObject.scene;
        com_tencent_mm_protocal_c_cba.xao = appBrandStatObject.fnp;
        com_tencent_mm_protocal_c_cba.fIs = appBrandStatObject.fIs;
        com_tencent_mm_protocal_c_cba.fIt = appBrandStatObject.fIt;
        com_tencent_mm_protocal_c_cba.xan = appBrandStatObject.jHc;
        com.tencent.mm.plugin.appbrand.report.a.e eVar2 = eVar.iqC.jDm.jHr;
        if (pVar != null) {
            h = eVar2.h(pVar);
        } else {
            h = eVar2.ajU();
        }
        com_tencent_mm_protocal_c_cba.xai = h.path;
        com_tencent_mm_protocal_c_cba.jIc = h.jHL == null ? null : h.jHL.path;
        if (eVar2.ub(h.path)) {
            i = 1;
        } else {
            i = 0;
        }
        com_tencent_mm_protocal_c_cba.jIh = i;
        x.i("MicroMsg.JsApiReportRealtimeAction", "report(%s), path %s, appState %d, sessionId %s, scene %d, sceneNote %s, preScene %d, preSceneNote %s, usedState %d, referPath %s, isEntrance %d", eVar.mAppId, com_tencent_mm_protocal_c_cba.xai, Integer.valueOf(com_tencent_mm_protocal_c_cba.xak), com_tencent_mm_protocal_c_cba.xal, Integer.valueOf(com_tencent_mm_protocal_c_cba.tlN), com_tencent_mm_protocal_c_cba.xao, Integer.valueOf(com_tencent_mm_protocal_c_cba.fIs), com_tencent_mm_protocal_c_cba.fIt, Integer.valueOf(com_tencent_mm_protocal_c_cba.xan), com_tencent_mm_protocal_c_cba.jIc, Integer.valueOf(com_tencent_mm_protocal_c_cba.jIh));
        AppBrandIDKeyBatchReport.a(com_tencent_mm_protocal_c_cba);
    }
}
