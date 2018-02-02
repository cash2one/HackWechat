package com.tencent.mm.bg.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    public final void a(int i, int i2, String str, k kVar) {
        g.CG().b(JsApiOpenWeRunSetting.CTRL_INDEX, this);
        if (kVar instanceof a) {
            x.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }
}
