package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment extends a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private GetIsEnrolledTask jht = null;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.jht = new GetIsEnrolledTask(jVar, i, a.sk(jSONObject.optString("checkAuthMode")), this);
        c.bj(this.jht);
        AppBrandMainProcessService.a(this.jht);
    }
}
