package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.plugin.webview.modeltools.g.a;
import java.io.File;
import java.io.FilenameFilter;

class g$a$1 implements FilenameFilter {
    final /* synthetic */ a tvh;

    g$a$1(a aVar) {
        this.tvh = aVar;
    }

    public final boolean accept(File file, String str) {
        return str.matches(".+_.+.\\.jpg");
    }
}
