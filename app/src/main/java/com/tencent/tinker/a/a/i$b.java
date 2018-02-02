package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$b extends AbstractList<n> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$b(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.Afd).Afs.size);
        return this.Afd.Id(i.a(this.Afd).Afs.dzw + (i * 8)).cGs();
    }

    public final int size() {
        return i.a(this.Afd).Afs.size;
    }
}
