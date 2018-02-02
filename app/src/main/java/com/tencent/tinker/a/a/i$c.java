package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$c extends AbstractList<p> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$c(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.Afd).Aft.size);
        return this.Afd.Id(i.a(this.Afd).Aft.dzw + (i * 8)).cGt();
    }

    public final int size() {
        return i.a(this.Afd).Aft.size;
    }
}
