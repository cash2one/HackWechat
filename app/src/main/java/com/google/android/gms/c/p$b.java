package com.google.android.gms.c;

import com.google.android.gms.c.p.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class p$b implements Set<Entry<K, V>> {
    final /* synthetic */ p aXL;

    p$b(p pVar) {
        this.aXL = pVar;
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int bB = this.aXL.bB();
        for (Entry entry : collection) {
            this.aXL.a(entry.getKey(), entry.getValue());
        }
        return bB != this.aXL.bB();
    }

    public final void clear() {
        this.aXL.bD();
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int h = this.aXL.h(entry.getKey());
        return h >= 0 ? n.b(this.aXL.n(h, 1), entry.getValue()) : false;
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return p.a(this, obj);
    }

    public final int hashCode() {
        int bB = this.aXL.bB() - 1;
        int i = 0;
        while (bB >= 0) {
            Object n = this.aXL.n(bB, 0);
            Object n2 = this.aXL.n(bB, 1);
            bB--;
            i += (n2 == null ? 0 : n2.hashCode()) ^ (n == null ? 0 : n.hashCode());
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.aXL.bB() == 0;
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new d(this.aXL);
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.aXL.bB();
    }

    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
