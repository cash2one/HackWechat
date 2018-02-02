package com.tencent.mm.plugin.fts.a.c;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Comparator;

public final class b implements Comparator<j> {
    public static final b mMz = new b();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        int i = jVar2.mLx - jVar.mLx;
        if (i != 0) {
            return i;
        }
        i = d.a(c.mKo, jVar.type, jVar2.type);
        if (i != 0) {
            return i;
        }
        i = d.c(c.mKt, jVar.mLr, jVar2.mLr);
        if (i != 0) {
            return i;
        }
        i = jVar.mMi - jVar2.mMi;
        if (i != 0) {
            return i;
        }
        if (jVar.mLr != 11 && jVar.mLr != 17 && jVar.mLr != 18) {
            return bh.az(jVar.mMj, "").compareToIgnoreCase(jVar2.mMj);
        }
        if (bh.ov(jVar.mMq)) {
            jVar.mMq = d.Bb(jVar.mLs);
            jVar.mMq = jVar.mMq.toLowerCase();
            if (!f.j(jVar.mMq.charAt(0))) {
                jVar.mMq = "~" + jVar.mMq;
            }
        }
        if (bh.ov(jVar2.mMq)) {
            jVar2.mMq = d.Bb(jVar2.mLs);
            jVar2.mMq = jVar2.mMq.toLowerCase();
            if (!f.j(jVar2.mMq.charAt(0))) {
                jVar2.mMq = "~" + jVar2.mMq;
            }
        }
        return jVar.mMq.compareToIgnoreCase(jVar2.mMq);
    }
}
