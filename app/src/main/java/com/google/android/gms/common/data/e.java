package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<T> implements Iterator<T> {
    protected final b<T> aMw;
    protected int aMx = -1;

    public e(b<T> bVar) {
        this.aMw = (b) w.ag(bVar);
    }

    public final boolean hasNext() {
        return this.aMx < this.aMw.getCount() + -1;
    }

    public final T next() {
        if (hasNext()) {
            b bVar = this.aMw;
            int i = this.aMx + 1;
            this.aMx = i;
            return bVar.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.aMx);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
