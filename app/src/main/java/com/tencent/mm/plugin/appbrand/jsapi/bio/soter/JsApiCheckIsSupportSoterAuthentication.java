package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication extends a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask jhx = null;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.jhx = new GetIsSupportSoterTask(jVar, i, this);
        c.bj(this.jhx);
        AppBrandMainProcessService.a(this.jhx);
    }
}
