package b.c.b;

import b.c.a;
import b.e.b;

public final class c implements b, b<Object> {
    private final Class<?> AuO;

    public c(Class<?> cls) {
        e.i(cls, "jClass");
        this.AuO = cls;
    }

    public final Class<?> cJx() {
        return this.AuO;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && e.h(a.a(this), a.a((b) obj));
    }

    public final int hashCode() {
        return a.a(this).hashCode();
    }

    public final String toString() {
        return this.AuO.toString() + " (Kotlin reflection is not available)";
    }
}
