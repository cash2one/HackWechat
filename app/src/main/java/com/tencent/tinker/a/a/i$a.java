package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$a extends AbstractList<f> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$a(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.Afd).Afu.size);
        return this.Afd.Id(i.a(this.Afd).Afu.dzw + (i * 32)).cGv();
    }

    public final int size() {
        return i.a(this.Afd).Afu.size;
    }
}
