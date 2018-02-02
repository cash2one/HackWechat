package com.tencent.mm.az;

import java.io.File;
import java.io.FileFilter;

class j$1 implements FileFilter {
    final /* synthetic */ j hJF;

    j$1(j jVar) {
        this.hJF = jVar;
    }

    public final boolean accept(File file) {
        return file.getName().endsWith("txt");
    }
}
