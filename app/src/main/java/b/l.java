package b;

import b.c.a.a;
import b.c.b.e;
import java.io.Serializable;

public final class l<T> implements b<T>, Serializable {
    private a<? extends T> AuE;
    private Object AuF = j.AuJ;

    public l(a<? extends T> aVar) {
        e.i(aVar, "initializer");
        this.AuE = aVar;
    }

    public final T getValue() {
        if (this.AuF == j.AuJ) {
            a aVar = this.AuE;
            if (aVar == null) {
                e.cJy();
            }
            this.AuF = aVar.invoke();
            this.AuE = null;
        }
        return this.AuF;
    }

    public final String toString() {
        return (this.AuF != j.AuJ ? 1 : null) != null ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
