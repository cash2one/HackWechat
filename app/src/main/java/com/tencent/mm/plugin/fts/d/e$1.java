package com.tencent.mm.plugin.fts.d;

import com.tencent.mm.plugin.fts.a.m;
import java.util.Comparator;

class e$1 implements Comparator<String> {
    final /* synthetic */ m mOM;

    e$1(m mVar) {
        this.mOM = mVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return this.mOM.stringCompareUtfBinary((String) obj, (String) obj2);
    }
}
