package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.m.b.a;

class o$1 implements b<WxaAttributes> {
    final /* synthetic */ a iOX;
    final /* synthetic */ o iOY;

    o$1(o oVar, a aVar) {
        this.iOY = oVar;
        this.iOX = aVar;
    }

    public final /* synthetic */ void d(int i, Object obj) {
        WxaAttributes wxaAttributes = (WxaAttributes) obj;
        if (this.iOX != null) {
            this.iOX.b(wxaAttributes);
        }
    }
}
