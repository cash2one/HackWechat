package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

class RuntimeLoadModuleTask$1 implements i<WxaPkgWrappingInfo> {
    final /* synthetic */ RuntimeLoadModuleTask jyz;

    public RuntimeLoadModuleTask$1(RuntimeLoadModuleTask runtimeLoadModuleTask) {
        this.jyz = runtimeLoadModuleTask;
    }

    public final /* synthetic */ void as(Object obj) {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) obj;
        this.jyz.pv(wxaPkgWrappingInfo == null ? null : wxaPkgWrappingInfo.iEa);
    }
}
