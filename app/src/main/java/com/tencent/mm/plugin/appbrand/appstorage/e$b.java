package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import java.io.File;

abstract class e$b implements a {
    final /* synthetic */ e iHW;

    public abstract j r(File file);

    private e$b(e eVar) {
        this.iHW = eVar;
    }

    public final j a(File file, Object... objArr) {
        return r(file);
    }
}
