package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;

public final class c implements Comparator<j> {
    public static final c mMA = new c();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        int i = jVar.mLr - jVar2.mLr;
        if (i != 0) {
            return i;
        }
        i = jVar.mMi - jVar2.mMi;
        return i == 0 ? jVar.mMj.compareTo(jVar2.mMj) : i;
    }
}
