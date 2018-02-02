package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadWeRunData$UploadMiniAppStepTask$1 implements a {
    final /* synthetic */ UploadMiniAppStepTask jet;

    JsApiUploadWeRunData$UploadMiniAppStepTask$1(UploadMiniAppStepTask uploadMiniAppStepTask) {
        this.jet = uploadMiniAppStepTask;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (kVar.getType() == 1949) {
            if (i == 0 && i2 == 0) {
                UploadMiniAppStepTask.a(this.jet, true);
                x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
            } else {
                UploadMiniAppStepTask.a(this.jet, false);
                x.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
            UploadMiniAppStepTask.a(this.jet);
        }
        return 0;
    }
}
