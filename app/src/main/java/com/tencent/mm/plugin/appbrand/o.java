package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;

public interface o {
    int YJ();

    c YK();

    void a(e eVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject);

    e b(e eVar);

    boolean c(e eVar);

    void close();

    void d(e eVar);

    void finish();
}
