package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.jsapi.e.c.a;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.b;
import java.util.HashMap;
import java.util.Map;

class c$1 implements b {
    final /* synthetic */ AppBrandInputInvokeHandler jjV;
    final /* synthetic */ c jjW;

    c$1(c cVar, AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jjW = cVar;
        this.jjV = appBrandInputInvokeHandler;
    }

    public final void bI(int i, int i2) {
        int inputId = this.jjV.getInputId();
        p kx = c.kx(inputId);
        if (kx != null && kx.isRunning()) {
            a aVar = new a((byte) 0);
            Map hashMap = new HashMap();
            hashMap.put("height", Integer.valueOf(f.lH(i2)));
            hashMap.put("lineCount", Integer.valueOf(i));
            hashMap.put("inputId", Integer.valueOf(inputId));
            aVar.az(kx.mAppId, 0).v(hashMap).f(new int[]{kx.hashCode()});
        }
    }
}
