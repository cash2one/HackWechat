package com.google.android.gms.c;

import com.google.android.gms.c.p.a;
import java.util.Collection;
import java.util.Iterator;

final class p$e implements Collection<V> {
    final /* synthetic */ p aXL;

    p$e(p pVar) {
        this.aXL = pVar;
    }

    public final boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.aXL.bD();
    }

    public final boolean contains(Object obj) {
        return this.aXL.i(obj) >= 0;
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.aXL.bB() == 0;
    }

    public final Iterator<V> iterator() {
        return new a(this.aXL, 1);
    }

    public final boolean remove(Object obj) {
        int i = this.aXL.i(obj);
        if (i < 0) {
            return false;
        }
        this.aXL.X(i);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        int i = 0;
        int bB = this.aXL.bB();
        boolean z = false;
        while (i < bB) {
            if (collection.contains(this.aXL.n(i, 1))) {
                this.aXL.X(i);
                i--;
                bB--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        int i = 0;
        int bB = this.aXL.bB();
        boolean z = false;
        while (i < bB) {
            if (!collection.contains(this.aXL.n(i, 1))) {
                this.aXL.X(i);
                i--;
                bB--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final int size() {
        return this.aXL.bB();
    }

    public final Object[] toArray() {
        return this.aXL.ab(1);
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.aXL.a(tArr, 1);
    }
}
