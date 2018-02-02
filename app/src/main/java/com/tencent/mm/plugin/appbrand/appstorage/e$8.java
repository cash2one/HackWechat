package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.p.h;
import java.io.File;

class e$8 implements e$a {
    final /* synthetic */ e iHW;

    e$8(e eVar) {
        this.iHW = eVar;
    }

    public final j a(File file, Object... objArr) {
        h hVar = (h) objArr[0];
        if (!file.exists()) {
            return j.RET_NOT_EXISTS;
        }
        if (!file.isFile()) {
            return j.ERR_PERMISSION_DENIED;
        }
        if (k.u(file)) {
            return j.ERR_SYMLINK;
        }
        if (hVar != null) {
            hVar.jRK = k.s(file);
        }
        return j.OK;
    }
}
