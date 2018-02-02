package com.google.android.gms.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class p$c implements Set<K> {
    final /* synthetic */ p aXL;

    p$c(p pVar) {
        this.aXL = pVar;
    }

    public final boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.aXL.bD();
    }

    public final boolean contains(Object obj) {
        return this.aXL.h(obj) >= 0;
    }

    public final boolean containsAll(Collection<?> collection) {
        Map bC = this.aXL.bC();
        for (Object containsKey : collection) {
            if (!bC.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return p.a(this, obj);
    }

    public final int hashCode() {
        int i = 0;
        for (int bB = this.aXL.bB() - 1; bB >= 0; bB--) {
            Object n = this.aXL.n(bB, 0);
            i += n == null ? 0 : n.hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.aXL.bB() == 0;
    }

    public final Iterator<K> iterator() {
        return new p$a(this.aXL, 0);
    }

    public final boolean remove(Object obj) {
        int h = this.aXL.h(obj);
        if (h < 0) {
            return false;
        }
        this.aXL.X(h);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        Map bC = this.aXL.bC();
        int size = bC.size();
        for (Object remove : collection) {
            bC.remove(remove);
        }
        return size != bC.size();
    }

    public final boolean retainAll(Collection<?> collection) {
        Map bC = this.aXL.bC();
        int size = bC.size();
        Iterator it = bC.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != bC.size();
    }

    public final int size() {
        return this.aXL.bB();
    }

    public final Object[] toArray() {
        return this.aXL.ab(0);
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.aXL.a(tArr, 0);
    }
}
