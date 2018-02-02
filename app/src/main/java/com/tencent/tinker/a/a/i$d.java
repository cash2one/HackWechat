package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$d extends AbstractList<r> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$d(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.Afd).Afr.size);
        return this.Afd.Id(i.a(this.Afd).Afr.dzw + (i * 12)).cGu();
    }

    public final int size() {
        return i.a(this.Afd).Afr.size;
    }
}
