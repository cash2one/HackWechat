package b;

import b.c.b.e;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class g<T> implements b<T>, Serializable {
    private static final AtomicReferenceFieldUpdater<g<?>, Object> AuH = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "AuF");
    public static final a AuI = new a();
    private b.c.a.a<? extends T> AuE;
    private volatile Object AuF = j.AuJ;
    private final Object AuG = j.AuJ;

    public static final class a {
        private a() {
        }
    }

    public g(b.c.a.a<? extends T> aVar) {
        e.i(aVar, "initializer");
        this.AuE = aVar;
    }

    public final T getValue() {
        if (this.AuF == j.AuJ) {
            b.c.a.a aVar = this.AuE;
            if (aVar != null) {
                if (AuH.compareAndSet(this, j.AuJ, aVar.invoke())) {
                    this.AuE = null;
                }
            }
        }
        return this.AuF;
    }

    public final String toString() {
        return (this.AuF != j.AuJ ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
