package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WxaWidgetDebugUI$2 implements a {
    final /* synthetic */ WxaWidgetDebugUI iVc;

    WxaWidgetDebugUI$2(WxaWidgetDebugUI wxaWidgetDebugUI) {
        this.iVc = wxaWidgetDebugUI;
    }

    public final void cw(boolean z) {
        this.iVc.iVb.field_openDebug = z;
        m Zk = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zk();
        c cVar = this.iVc.iVb;
        if (cVar != null && !bh.ov(cVar.field_appId)) {
            cVar.field_appIdHash = cVar.field_appId.hashCode();
            Zk.a(cVar);
        }
    }
}
