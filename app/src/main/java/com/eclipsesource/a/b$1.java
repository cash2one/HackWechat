package com.eclipsesource.a;

import java.util.Iterator;

class b$1 implements Iterator<h> {
    final /* synthetic */ Iterator abx;
    final /* synthetic */ b aby;

    b$1(b bVar, Iterator it) {
        this.aby = bVar;
        this.abx = it;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (h) this.abx.next();
    }

    public final boolean hasNext() {
        return this.abx.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
