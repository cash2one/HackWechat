package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$f extends AbstractList<String> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$f(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        return tc(i);
    }

    public final String tc(int i) {
        i.fH(i, i.a(this.Afd).Afp.size);
        return this.Afd.Id(this.Afd.Id(i.a(this.Afd).Afp.dzw + (i * 4)).aif.getInt()).cGq().value;
    }

    public final int size() {
        return i.a(this.Afd).Afp.size;
    }
}
