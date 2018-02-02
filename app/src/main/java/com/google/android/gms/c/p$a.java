package com.google.android.gms.c;

import java.util.Iterator;

final class p$a<T> implements Iterator<T> {
    final /* synthetic */ p aXL;
    int hX;
    int mIndex;
    final int wn;
    boolean wo = false;

    p$a(p pVar, int i) {
        this.aXL = pVar;
        this.wn = i;
        this.hX = pVar.bB();
    }

    public final boolean hasNext() {
        return this.mIndex < this.hX;
    }

    public final T next() {
        T n = this.aXL.n(this.mIndex, this.wn);
        this.mIndex++;
        this.wo = true;
        return n;
    }

    public final void remove() {
        if (this.wo) {
            this.mIndex--;
            this.hX--;
            this.wo = false;
            this.aXL.X(this.mIndex);
            return;
        }
        throw new IllegalStateException();
    }
}
