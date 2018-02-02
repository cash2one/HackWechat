package b;

import b.c.a.a;
import b.c.b.e;
import java.io.Serializable;

public final class h<T> implements b<T>, Serializable {
    private a<? extends T> AuE;
    private volatile Object AuF;
    private final Object lock;

    private h(a<? extends T> aVar, Object obj) {
        e.i(aVar, "initializer");
        this.AuE = aVar;
        this.AuF = j.AuJ;
        this.lock = this;
    }

    public final T getValue() {
        T t = this.AuF;
        if (t == j.AuJ) {
            synchronized (this.lock) {
                t = this.AuF;
                if (t == j.AuJ) {
                    a aVar = this.AuE;
                    if (aVar == null) {
                        e.cJy();
                    }
                    t = aVar.invoke();
                    this.AuF = t;
                    this.AuE = null;
                }
            }
        }
        return t;
    }

    public final String toString() {
        return (this.AuF != j.AuJ ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
