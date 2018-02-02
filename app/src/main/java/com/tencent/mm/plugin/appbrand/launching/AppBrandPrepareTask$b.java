package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;

public interface AppBrandPrepareTask$b {
    void a(a aVar);

    void b(AppBrandSysConfig appBrandSysConfig);

    void js(int i);

    void onDownloadStarted();
}
