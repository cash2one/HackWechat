package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.t.3;
import java.io.File;
import java.io.FileFilter;

class t$3$2 implements FileFilter {
    final /* synthetic */ 3 zXY;

    t$3$2(3 3) {
        this.zXY = 3;
    }

    public final boolean accept(File file) {
        return file.getName().endsWith("tbs.conf");
    }
}
