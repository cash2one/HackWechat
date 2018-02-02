package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.Comparator;

public final class a implements Comparator<j> {
    public static final a mMy = new a();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        int i = jVar2.mLx - jVar.mLx;
        if (i != 0) {
            return i;
        }
        if (jVar2.mLx >= 50 && jVar.mLx >= 50) {
            i = d.c(c.mKt, jVar.mLr, jVar2.mLr);
            if (i != 0) {
                return i;
            }
        }
        i = jVar2.mMr - jVar.mMr;
        if (i != 0) {
            return i;
        }
        if (jVar2.timestamp > jVar.timestamp) {
            return 1;
        }
        return jVar2.timestamp < jVar.timestamp ? -1 : 0;
    }
}
