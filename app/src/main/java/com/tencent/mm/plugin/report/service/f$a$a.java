package com.tencent.mm.plugin.report.service;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class f$a$a implements FileFilter {
    f$a$a() {
    }

    public final boolean accept(File file) {
        if (Pattern.matches("cpu[0-9]", file.getName())) {
            return true;
        }
        return false;
    }
}
