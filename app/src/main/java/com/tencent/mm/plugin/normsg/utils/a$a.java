package com.tencent.mm.plugin.normsg.utils;

import java.util.Collection;
import java.util.HashSet;

final class a$a<T> extends HashSet<T> {
    private a$a() {
    }

    public final boolean add(T t) {
        if (!contains(t)) {
            return super.add(t);
        }
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
}
