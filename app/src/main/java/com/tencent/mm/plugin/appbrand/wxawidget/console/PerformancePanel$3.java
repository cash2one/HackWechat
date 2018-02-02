package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.d;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class PerformancePanel$3 implements a {
    final /* synthetic */ View iVj;
    final /* synthetic */ PerformancePanel khR;

    PerformancePanel$3(PerformancePanel performancePanel, View view) {
        this.khR = performancePanel;
        this.iVj = view;
    }

    public final void cw(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
        c.cs(z);
        this.iVj.setEnabled(z);
        this.khR.iVe.setEnabled(z);
        this.khR.iVf.setEnabled(z);
        this.khR.iVg.setEnabled(z);
    }
}
