package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.d;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WxaWidgetPerformanceUI$4 implements a {
    final /* synthetic */ WxaWidgetPerformanceUI iVh;
    final /* synthetic */ View iVj;

    WxaWidgetPerformanceUI$4(WxaWidgetPerformanceUI wxaWidgetPerformanceUI, View view) {
        this.iVh = wxaWidgetPerformanceUI;
        this.iVj = view;
    }

    public final void cw(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
        c.cs(z);
        this.iVj.setEnabled(z);
        this.iVh.iVe.setEnabled(z);
        this.iVh.iVf.setEnabled(z);
        this.iVh.iVg.setEnabled(z);
    }
}
