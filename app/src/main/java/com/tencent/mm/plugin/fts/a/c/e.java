package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;

public final class e implements Comparator<j> {
    public static final e mMC = new e();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        if (jVar2.timestamp < jVar.timestamp) {
            return -1;
        }
        return jVar2.timestamp == jVar.timestamp ? 0 : 1;
    }
}
