package com.tencent.smtt.utils;

import com.tencent.smtt.utils.s.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class s$b {
    final /* synthetic */ s Abu;
    public Map<String, a> iFr = new HashMap();

    public s$b(s sVar, File file) {
        this.Abu = sVar;
        this.iFr.clear();
        W(file);
    }

    private void W(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File W : listFiles) {
                W(W);
            }
        } else if (file.isFile()) {
            String name = file.getName();
            long length = file.length();
            long lastModified = file.lastModified();
            if (name != null && name.length() > 0 && length > 0 && lastModified > 0) {
                a aVar = new a(this.Abu, name, length, lastModified);
                if (!this.iFr.containsKey(name)) {
                    this.iFr.put(name, aVar);
                }
            }
        }
    }
}
