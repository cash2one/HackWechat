package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$h extends AbstractList<String> implements RandomAccess {
    final /* synthetic */ i Afd;

    private i$h(i iVar) {
        this.Afd = iVar;
    }

    public final /* synthetic */ Object get(int i) {
        return i.b(this.Afd).tc(this.Afd.Ie(i));
    }

    public final int size() {
        return i.a(this.Afd).Afq.size;
    }
}
