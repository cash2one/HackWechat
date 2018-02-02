package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$1 extends b {
    final /* synthetic */ e iHW;

    e$1(e eVar) {
        this.iHW = eVar;
        super(eVar, (byte) 0);
    }

    public final j r(File file) {
        return file.exists() ? j.iIt : j.iIz;
    }
}
