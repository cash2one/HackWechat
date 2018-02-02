package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class g<K, V> {
    b wk;
    c wl;
    e wm;

    final class a<T> implements Iterator<T> {
        int hX;
        int mIndex;
        final int wn;
        boolean wo = false;
        final /* synthetic */ g wp;

        a(g gVar, int i) {
            this.wp = gVar;
            this.wn = i;
            this.hX = gVar.bB();
        }

        public final boolean hasNext() {
            return this.mIndex < this.hX;
        }

        public final T next() {
            T n = this.wp.n(this.mIndex, this.wn);
            this.mIndex++;
            this.wo = true;
            return n;
        }

        public final void remove() {
            if (this.wo) {
                this.mIndex--;
                this.hX--;
                this.wo = false;
                this.wp.X(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ g wp;

        b(g gVar) {
            this.wp = gVar;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bB = this.wp.bB();
            for (Entry entry : collection) {
                this.wp.a(entry.getKey(), entry.getValue());
            }
            return bB != this.wp.bB();
        }

        public final void clear() {
            this.wp.bD();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int h = this.wp.h(entry.getKey());
            if (h >= 0) {
                return b.b(this.wp.n(h, 1), entry.getValue());
            }
            return false;
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
            return this.wp.bB() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(this.wp);
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
            return this.wp.bB();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int bB = this.wp.bB() - 1;
            int i = 0;
            while (bB >= 0) {
                Object n = this.wp.n(bB, 0);
                Object n2 = this.wp.n(bB, 1);
                bB--;
                i += (n2 == null ? 0 : n2.hashCode()) ^ (n == null ? 0 : n.hashCode());
            }
            return i;
        }
    }

    final class c implements Set<K> {
        final /* synthetic */ g wp;

        c(g gVar) {
            this.wp = gVar;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.wp.bD();
        }

        public final boolean contains(Object obj) {
            return this.wp.h(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bC = this.wp.bC();
            for (Object containsKey : collection) {
                if (!bC.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.wp.bB() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(this.wp, 0);
        }

        public final boolean remove(Object obj) {
            int h = this.wp.h(obj);
            if (h < 0) {
                return false;
            }
            this.wp.X(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bC = this.wp.bC();
            int size = bC.size();
            for (Object remove : collection) {
                bC.remove(remove);
            }
            return size != bC.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return g.a(this.wp.bC(), (Collection) collection);
        }

        public final int size() {
            return this.wp.bB();
        }

        public final Object[] toArray() {
            return this.wp.ab(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.wp.a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bB = this.wp.bB() - 1; bB >= 0; bB--) {
                Object n = this.wp.n(bB, 0);
                i += n == null ? 0 : n.hashCode();
            }
            return i;
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mIndex;
        final /* synthetic */ g wp;
        int wq;
        boolean wr = false;

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.wr = true;
            return this;
        }

        d(g gVar) {
            this.wp = gVar;
            this.wq = gVar.bB() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.wq;
        }

        public final void remove() {
            if (this.wr) {
                this.wp.X(this.mIndex);
                this.mIndex--;
                this.wq--;
                this.wr = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.wr) {
                return this.wp.n(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.wr) {
                return this.wp.n(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.wr) {
                return this.wp.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.wr) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (b.b(entry.getKey(), this.wp.n(this.mIndex, 0)) && b.b(entry.getValue(), this.wp.n(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.wr) {
                Object n = this.wp.n(this.mIndex, 0);
                Object n2 = this.wp.n(this.mIndex, 1);
                int hashCode = n == null ? 0 : n.hashCode();
                if (n2 != null) {
                    i = n2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        final /* synthetic */ g wp;

        e(g gVar) {
            this.wp = gVar;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.wp.bD();
        }

        public final boolean contains(Object obj) {
            return this.wp.i(obj) >= 0;
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
            return this.wp.bB() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(this.wp, 1);
        }

        public final boolean remove(Object obj) {
            int i = this.wp.i(obj);
            if (i < 0) {
                return false;
            }
            this.wp.X(i);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int bB = this.wp.bB();
            boolean z = false;
            while (i < bB) {
                if (collection.contains(this.wp.n(i, 1))) {
                    this.wp.X(i);
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
            int bB = this.wp.bB();
            boolean z = false;
            while (i < bB) {
                if (!collection.contains(this.wp.n(i, 1))) {
                    this.wp.X(i);
                    i--;
                    bB--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.wp.bB();
        }

        public final Object[] toArray() {
            return this.wp.ab(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.wp.a((Object[]) tArr, 1);
        }
    }

    protected abstract void X(int i);

    protected abstract V a(int i, V v);

    protected abstract void a(K k, V v);

    protected abstract int bB();

    protected abstract Map<K, V> bC();

    protected abstract void bD();

    protected abstract int h(Object obj);

    protected abstract int i(Object obj);

    protected abstract Object n(int i, int i2);

    g() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] ab(int i) {
        int bB = bB();
        Object[] objArr = new Object[bB];
        for (int i2 = 0; i2 < bB; i2++) {
            objArr[i2] = n(i2, i);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i) {
        T[] tArr2;
        int bB = bB();
        if (tArr.length < bB) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bB);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < bB; i2++) {
            tArr2[i2] = n(i2, i);
        }
        if (tArr2.length > bB) {
            tArr2[bB] = null;
        }
        return tArr2;
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
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }
}
