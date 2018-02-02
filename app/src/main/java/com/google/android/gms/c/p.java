package com.google.android.gms.c;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class p<K, V> {
    b aXI;
    c aXJ;
    e aXK;

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        final /* synthetic */ p aXL;
        int mIndex;
        int wq;
        boolean wr = false;

        d(p pVar) {
            this.aXL = pVar;
            this.wq = pVar.bB() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object obj) {
            if (!this.wr) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                return n.b(entry.getKey(), this.aXL.n(this.mIndex, 0)) && n.b(entry.getValue(), this.aXL.n(this.mIndex, 1));
            }
        }

        public final K getKey() {
            if (this.wr) {
                return this.aXL.n(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.wr) {
                return this.aXL.n(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean hasNext() {
            return this.mIndex < this.wq;
        }

        public final int hashCode() {
            int i = 0;
            if (this.wr) {
                Object n = this.aXL.n(this.mIndex, 0);
                Object n2 = this.aXL.n(this.mIndex, 1);
                int hashCode = n == null ? 0 : n.hashCode();
                if (n2 != null) {
                    i = n2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.wr = true;
            return this;
        }

        public final void remove() {
            if (this.wr) {
                this.aXL.X(this.mIndex);
                this.mIndex--;
                this.wq--;
                this.wr = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final V setValue(V v) {
            if (this.wr) {
                return this.aXL.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    p() {
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    protected abstract void X(int i);

    protected abstract V a(int i, V v);

    protected abstract void a(K k, V v);

    public final <T> T[] a(T[] tArr, int i) {
        int bB = bB();
        T[] tArr2 = tArr.length < bB ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bB) : tArr;
        for (int i2 = 0; i2 < bB; i2++) {
            tArr2[i2] = n(i2, i);
        }
        if (tArr2.length > bB) {
            tArr2[bB] = null;
        }
        return tArr2;
    }

    public final Object[] ab(int i) {
        int bB = bB();
        Object[] objArr = new Object[bB];
        for (int i2 = 0; i2 < bB; i2++) {
            objArr[i2] = n(i2, i);
        }
        return objArr;
    }

    protected abstract int bB();

    protected abstract Map<K, V> bC();

    protected abstract void bD();

    protected abstract int h(Object obj);

    protected abstract int i(Object obj);

    protected abstract Object n(int i, int i2);
}
