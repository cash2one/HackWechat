package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a;
import com.tencent.mm.plugin.appbrand.launching.k.b;

class RuntimeLoadModuleTask$a$1 implements b {
    final /* synthetic */ i gMv;
    final /* synthetic */ a jyA;

    RuntimeLoadModuleTask$a$1(a aVar, i iVar) {
        this.jyA = aVar;
        this.gMv = iVar;
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (this.gMv != null) {
            this.gMv.as(wxaPkgWrappingInfo);
        }
    }
}
