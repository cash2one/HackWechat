package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    final /* synthetic */ f iSd;

    f$1(f fVar) {
        this.iSd = fVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", new Object[]{str});
        }
    }
}
