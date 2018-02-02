package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class x$1 implements FileFilter {
    x$1() {
    }

    public final boolean accept(File file) {
        return !file.getName().endsWith(".dex");
    }
}
