package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect extends a {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask jhp = null;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.jhp = new GetIsSupportFaceTask(jVar, i, this);
        c.bj(this.jhp);
        AppBrandMainProcessService.a(this.jhp);
    }
}
