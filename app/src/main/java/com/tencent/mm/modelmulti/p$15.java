package com.tencent.mm.modelmulti;

import com.tencent.mm.modelmulti.c.b;
import java.util.Comparator;

class p$15 implements Comparator<b> {
    final /* synthetic */ p hGP;

    p$15(p pVar) {
        this.hGP = pVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        long j = (long) (((b) obj).tag - ((b) obj2).tag);
        if (j > 0) {
            return 1;
        }
        return j == 0 ? 0 : -1;
    }
}
