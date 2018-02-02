package com.eclipsesource.a;

import com.eclipsesource.a.e.b;
import java.util.Iterator;

class e$1 implements Iterator<b> {
    final /* synthetic */ Iterator abF;
    final /* synthetic */ Iterator abG;
    final /* synthetic */ e abH;

    e$1(e eVar, Iterator it, Iterator it2) {
        this.abH = eVar;
        this.abF = it;
        this.abG = it2;
    }

    public final /* synthetic */ Object next() {
        return new b((String) this.abF.next(), (h) this.abG.next());
    }

    public final boolean hasNext() {
        return this.abF.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
