package com.tencent.mm.modelmulti;

import java.io.File;
import java.util.Comparator;

class p$4 implements Comparator<File> {
    final /* synthetic */ p hGP;

    p$4(p pVar) {
        this.hGP = pVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
        if (lastModified > 0) {
            return 1;
        }
        return lastModified == 0 ? 0 : -1;
    }

    public final boolean equals(Object obj) {
        return true;
    }
}
