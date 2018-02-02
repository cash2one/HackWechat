package b.a;

import java.util.Iterator;

public abstract class a implements b.c.b.a.a, Iterator<Integer> {
    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }
}
