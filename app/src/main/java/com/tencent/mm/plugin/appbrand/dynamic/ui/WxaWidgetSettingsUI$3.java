package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WxaWidgetSettingsUI$3 implements a {
    final /* synthetic */ WxaWidgetSettingsUI iVk;

    WxaWidgetSettingsUI$3(WxaWidgetSettingsUI wxaWidgetSettingsUI) {
        this.iVk = wxaWidgetSettingsUI;
    }

    public final void cw(boolean z) {
        DebuggerInfo rr = b.rr(this.iVk.appId);
        if (rr == null) {
            rr = new DebuggerInfo();
            b.a(this.iVk.appId, rr);
        }
        rr.iSR = z;
    }
}
