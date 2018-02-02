package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;

class AppBrandOpReportLogic$a$1 implements a {
    AppBrandOpReportLogic$a$1() {
    }

    public final void aY(Object obj) {
        if (obj instanceof AppBrandOnOpReportStartEvent) {
            e oQ = com.tencent.mm.plugin.appbrand.a.oQ(((AppBrandOnOpReportStartEvent) obj).appId);
            if (oQ != null) {
                a.se(oQ.mAppId);
            }
        }
    }
}
