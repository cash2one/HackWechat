package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;

class PerformancePanel$b implements h<IPCBoolean, IPCVoid> {
    private PerformancePanel$b() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        if (((IPCBoolean) obj).value) {
            c.qp("jsapi_draw_canvas");
        } else {
            c.qq("jsapi_draw_canvas");
        }
    }
}
