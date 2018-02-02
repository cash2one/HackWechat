package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.LoadParams;
import com.tencent.mm.plugin.appbrand.launching.k.a;

final class RuntimeLoadModuleTask$a implements h<LoadParams, WxaPkgWrappingInfo> {
    private RuntimeLoadModuleTask$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        LoadParams loadParams = (LoadParams) obj;
        k f = a.f(loadParams.appId, loadParams.iEF, loadParams.fvM, loadParams.iGL);
        f.a(new 1(this, iVar));
        f.prepareAsync();
    }
}
