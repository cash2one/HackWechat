package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.p.h;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

class e$7 implements a {
    final /* synthetic */ e iHW;

    e$7(e eVar) {
        this.iHW = eVar;
    }

    public final j a(File file, Object... objArr) {
        if (!file.isDirectory()) {
            return j.iIB;
        }
        if (k.u(file)) {
            return j.iID;
        }
        List linkedList = new LinkedList();
        file.listFiles(new 1(this, Pattern.quote(file.getAbsolutePath()), linkedList));
        ((h) objArr[0]).jRK = linkedList;
        return j.iIt;
    }
}
