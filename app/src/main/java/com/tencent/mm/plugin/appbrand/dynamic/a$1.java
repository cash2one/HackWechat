package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements c {
    final /* synthetic */ String fgU;
    final /* synthetic */ a iRA;
    final /* synthetic */ String iRy;
    final /* synthetic */ Bundle iRz;
    final /* synthetic */ String uR;

    public a$1(a aVar, String str, String str2, String str3, Bundle bundle) {
        this.iRA = aVar;
        this.iRy = str;
        this.uR = str2;
        this.fgU = str3;
        this.iRz = bundle;
    }

    public final void i(Bundle bundle) {
        if (this.iRy.equals(this.iRA.iRw)) {
            int i = bundle.getInt("op");
            if (i == 0) {
                this.iRA.iRx.cleanup();
            } else if (i == 1) {
                g.pQN.a(635, 0, 1, false);
                WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) bundle.getParcelable("fwContext");
                if (!bundle.getBoolean("success", false) || wxaWidgetContext == null) {
                    x.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", new Object[]{this.uR});
                    this.iRA.iRx.jT(1);
                    g.pQN.a(635, 2, 1, false);
                } else if (wxaWidgetContext.acM() != 1) {
                    x.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", new Object[]{this.uR});
                    this.iRA.iRx.jT(2);
                    g.pQN.a(635, 2, 1, false);
                } else {
                    i.a(this.uR, wxaWidgetContext);
                    this.iRA.iRx.d(this.uR, this.fgU, this.iRz);
                    g.pQN.a(635, 1, 1, false);
                }
            }
        }
    }
}
