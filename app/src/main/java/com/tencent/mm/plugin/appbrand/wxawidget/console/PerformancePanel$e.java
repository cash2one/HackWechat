package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.collector.c;

class PerformancePanel$e implements j<IPCString, IPCString> {
    private PerformancePanel$e() {
    }

    public final /* synthetic */ Object at(Object obj) {
        return new IPCString(c.qo(((IPCString) obj).value).toString());
    }
}
