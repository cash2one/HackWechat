package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class t$6 implements FileFilter {
    final /* synthetic */ t zXV;

    t$6(t tVar) {
        this.zXV = tVar;
    }

    public final boolean accept(File file) {
        return file.getName().endsWith(".jar");
    }
}
