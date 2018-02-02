package com.tencent.mm.az;

import java.io.File;
import java.io.FileFilter;

class r$4 implements FileFilter {
    final /* synthetic */ r hJT;

    r$4(r rVar) {
        this.hJT = rVar;
    }

    public final boolean accept(File file) {
        return file.getName().endsWith("txt");
    }
}
