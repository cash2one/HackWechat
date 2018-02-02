package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;

public final class AppBrandOpReportLogic$a {
    private static boolean joI = false;

    public static synchronized void agE() {
        synchronized (AppBrandOpReportLogic$a.class) {
            if (!joI) {
                MMToClientEvent.a(new 1());
                joI = true;
            }
        }
    }
}
