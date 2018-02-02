package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$6 extends b {
    final /* synthetic */ e iHW;

    e$6(e eVar) {
        this.iHW = eVar;
        super(eVar, (byte) 0);
    }

    public final j r(File file) {
        if (file.isFile() || !file.exists()) {
            return j.iIz;
        }
        if (file.equals(e.a(this.iHW))) {
            return j.iIx;
        }
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            if (listFiles.length != 1) {
                return j.iIA;
            }
            if (!listFiles[0].getName().equals(".nomedia")) {
                return j.iIA;
            }
            listFiles[0].delete();
        }
        if (file.delete()) {
            return j.iIt;
        }
        return j.iIu;
    }
}
