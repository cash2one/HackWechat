package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.113;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.d.a;
import com.tencent.mm.sdk.platformtools.x;

class g$113$1 implements a {
    final /* synthetic */ 113 tJx;

    g$113$1(113 113) {
        this.tJx = 113;
    }

    public final void n(boolean z, boolean z2) {
        x.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            this.tJx.tIj.a(this.tJx.tIg, "launchApplication:ok", null);
        } else {
            this.tJx.tIj.a(this.tJx.tIg, "launchApplication:fail", null);
        }
    }
}
