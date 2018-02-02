package com.tencent.mm.app;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

class i$2 implements FilenameFilter {
    String ffw = this.val$context.getPackageName();
    final /* synthetic */ i ffx;
    final /* synthetic */ Context val$context;

    i$2(i iVar, Context context) {
        this.ffx = iVar;
        this.val$context = context;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.ffw);
    }
}
