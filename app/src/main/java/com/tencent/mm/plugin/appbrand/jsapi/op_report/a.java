package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.jsapi.f;

final class a extends f {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final a joV = new a();

    a() {
    }

    static synchronized void se(String str) {
        synchronized (a.class) {
            joV.az(str, 0).afs();
        }
    }
}
