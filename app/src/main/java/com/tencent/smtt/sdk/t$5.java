package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class t$5 implements FileFilter {
    final /* synthetic */ t zXV;

    t$5(t tVar) {
        this.zXV = tVar;
    }

    public final boolean accept(File file) {
        return file.getName().endsWith(".jar");
    }
}
