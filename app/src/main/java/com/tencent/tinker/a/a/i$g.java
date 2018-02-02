package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$g extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$g(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(this.Afd.Ie(i));
    }

    public final int size() {
        return i.a(this.Afd).Afq.size;
    }
}
