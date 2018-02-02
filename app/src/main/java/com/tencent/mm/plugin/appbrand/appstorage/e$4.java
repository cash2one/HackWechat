package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$4 extends b {
    final /* synthetic */ e iHW;

    e$4(e eVar) {
        this.iHW = eVar;
        super(eVar, (byte) 0);
    }

    public final j r(File file) {
        if (file.exists()) {
            return file.isDirectory() ? j.iIt : j.iIB;
        } else {
            return j.iIz;
        }
    }
}
