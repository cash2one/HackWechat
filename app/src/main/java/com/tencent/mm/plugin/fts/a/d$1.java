package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;
import java.util.Map;

class d$1 implements Comparator<j> {
    final /* synthetic */ Map mKH;

    d$1(Map map) {
        this.mKH = map;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return d.a(this.mKH, ((j) obj).type, ((j) obj2).type);
    }
}
