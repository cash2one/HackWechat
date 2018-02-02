package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;

class e$5 extends e$b {
    final /* synthetic */ e iHW;

    e$5(e eVar) {
        this.iHW = eVar;
        super(eVar);
    }

    public final j r(File file) {
        if (file.exists()) {
            return j.iIy;
        }
        return file.mkdir() ? j.iIt : j.iIu;
    }
}
