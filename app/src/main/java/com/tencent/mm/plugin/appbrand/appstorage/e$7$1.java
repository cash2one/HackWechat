package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appstorage.e.7;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

class e$7$1 implements FileFilter {
    final /* synthetic */ String iHX;
    final /* synthetic */ List iHY;
    final /* synthetic */ 7 iHZ;

    e$7$1(7 7, String str, List list) {
        this.iHZ = 7;
        this.iHX = str;
        this.iHY = list;
    }

    public final boolean accept(File file) {
        boolean z = !file.getName().endsWith(".nomedia");
        if (z) {
            h hVar = new h();
            hVar.fileName = a.px(file.getAbsolutePath().replaceFirst(this.iHX, ""));
            this.iHY.add(hVar);
        }
        return z;
    }
}
