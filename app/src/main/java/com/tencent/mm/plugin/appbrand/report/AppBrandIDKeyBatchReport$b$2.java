package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDKeyBatchReport$b$2 implements a {
    AppBrandIDKeyBatchReport$b$2() {
    }

    public final boolean uF() {
        x.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
        b.uj();
        return true;
    }
}
