package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class PerformancePanel$5 implements a {
    final /* synthetic */ PerformancePanel khR;

    PerformancePanel$5(PerformancePanel performancePanel) {
        this.khR = performancePanel;
    }

    public final void cw(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), PerformancePanel$c.class, null);
        if (z) {
            c.qp("widget_launch");
        } else {
            c.qq("widget_launch");
        }
    }
}
